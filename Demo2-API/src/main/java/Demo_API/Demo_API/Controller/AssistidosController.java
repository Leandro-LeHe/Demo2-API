package Demo_API.Demo_API.Controller;


import Demo_API.Demo_API.Service.AssistidosService;
import Demo_API.Demo_API.Model.AssistidosEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assistidos")
public class AssistidosController {

    private final AssistidosService assistidosService;

    public AssistidosController(AssistidosService assistidosService) {
        this.assistidosService = assistidosService;
    }

    @GetMapping
    public ResponseEntity<List<AssistidosEntity>> listarCadastros() {
        List<AssistidosEntity>  assistidos = assistidosService.listarService();
        return ResponseEntity.status(HttpStatus.OK).body(assistidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssistidosEntity> buscarCadastro(@PathVariable Long id) {
        AssistidosEntity assistidosEntity = assistidosService.buscarOuFalharService(id);

        return ResponseEntity.status(HttpStatus.OK).body(assistidosEntity);
    }

    @PostMapping
    // boa pratica é ja retornar o objeto que fez o post ou DTO
    public ResponseEntity<AssistidosEntity> salvarCadastro(@RequestBody AssistidosEntity assistidosEntity) {
        AssistidosEntity assistido = assistidosService.salvarService(assistidosEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(assistido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCadastro(@PathVariable Long id) {
        assistidosService.deletarService(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<AssistidosEntity> atualizarCadastro(@PathVariable Long id,
                                                              @RequestBody AssistidosEntity dadosAtualizados) {
        AssistidosEntity assistidoAtualizado = assistidosService.atualizarAssistido(id, dadosAtualizados);
        return ResponseEntity.ok(assistidoAtualizado);
    }



}

