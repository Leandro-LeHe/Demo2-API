package Demo_API.Demo_API.Controller;

import Demo_API.Demo_API.Model.CadastroEntity;
import Demo_API.Demo_API.Service.CadastroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/assistidos")
public class CadastroController {

    private final CadastroService cadastroService;


    public CadastroController(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    @GetMapping
    public ResponseEntity<List<CadastroEntity>> listarCadastros() {
        System.out.println("Olá, Leandro!");
        List<CadastroEntity> assistidos = cadastroService.listarService();
        return ResponseEntity.status(HttpStatus.OK).body(assistidos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CadastroEntity> buscarPorID(@PathVariable Long id) {
        CadastroEntity assistidosEntity = cadastroService.buscarOuFalharService(id);
        return ResponseEntity.status(HttpStatus.OK).body(assistidosEntity);
    }


    @PostMapping
        //  Conversão (biblioteca Jackson ObjectMapper)
    public ResponseEntity<CadastroEntity> salvarCadastro(@RequestBody CadastroEntity assistidos) {
        System.out.println("Olá, Leandro!");
        CadastroEntity user = cadastroService.salvarService(assistidos);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCadastro(@PathVariable Long id) {
        cadastroService.deletarService(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<CadastroEntity> atualizarCadastro(@PathVariable Long id,
                                                            @RequestBody CadastroEntity dadosAtualizados) {
        CadastroEntity cadastroAtualizado = cadastroService.atualizarService(id, dadosAtualizados);
        return ResponseEntity.ok(cadastroAtualizado);
    }

}
