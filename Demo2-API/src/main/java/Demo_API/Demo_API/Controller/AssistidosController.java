package Demo_API.Demo_API.Controller;


import Demo_API.Demo_API.Model.AssistidosEntity;
import Demo_API.Demo_API.Service.AssistidosService;
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
 public List<AssistidosEntity> listarCadastros() {
        return assistidosService.listarAssistidos();
 }

 @GetMapping("/{id}")
    public ResponseEntity<AssistidosEntity> buscarCadastro(@PathVariable Long id) {
        return assistidosService.buscarPorid(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
 }

@PostMapping
    // boa pratica é ja retornar o objeto que fez o post ou DTO
    public AssistidosEntity salvarCadastro(@RequestBody AssistidosEntity assistidosEntity) {
    return assistidosService.salvarAssistido(assistidosEntity);

}

@DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCadastro(@PathVariable Long id) {
       assistidosService.deletarAssistido(id);
       return ResponseEntity.noContent().build();
    }


}

