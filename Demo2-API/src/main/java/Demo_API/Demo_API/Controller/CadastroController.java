package Demo_API.Demo_API.Controller;

import Demo_API.Demo_API.DTO.DtoCadastro;
import Demo_API.Demo_API.DTO.Mapper.CadastroMapper;
import Demo_API.Demo_API.DTO.UsuarioResponseDto;
import Demo_API.Demo_API.Model.CadastroEntity;
import Demo_API.Demo_API.Service.CadastroService;
import Demo_API.Demo_API.Web.ErrorMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.modelmapper.internal.bytebuddy.build.Plugin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Cadastro de assistidos", description = "Contém todos os endpoints para cadastro")
@RestController
@RequestMapping("/assistidos")
public class CadastroController {

    private final CadastroService cadastroService;


    public CadastroController(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }




    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> listarCadastros() {
        List<CadastroEntity> assistidos = cadastroService.listarService();
        return ResponseEntity.status(HttpStatus.OK).body(CadastroMapper.toListDto(assistidos));
    }



    @Operation(summary = "Buscar cadastro por ID",
            description = "EndPoint para buscar cadastro",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Cadastro encontrado!",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = UsuarioResponseDto.class))),
                    @ApiResponse(responseCode = "404", description = "Cadastro não encontrado!",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorMessage.class))),
            }
    )

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> buscarPorID(@PathVariable Long id) {
        CadastroEntity user = cadastroService.buscarOuFalharService(id);
        return ResponseEntity.ok(CadastroMapper.toDto(user));
    }


    @Operation(summary = "Cadastrar",
            description = "EndPoint para cadastrar",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso!",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = UsuarioResponseDto.class))),
                    @ApiResponse(responseCode = "409", description = "Usuário já cadastrado!",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "422", description = "Dados inválidos!",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorMessage.class))),
            }
    )
    @PostMapping
    //  Conversão (biblioteca Jackson ObjectMapper)
    public ResponseEntity<CadastroEntity> salvarCadastro(@Valid @RequestBody CadastroEntity assistidos) {
        CadastroEntity user = cadastroService.salvarService(assistidos);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCadastro(@PathVariable Long id) {
        cadastroService.deletarService(id);
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Atualizar cadastro",
            description = "EndPoint para atualizar cadastro",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Cadastro atualizado!",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Void.class))),
                    @ApiResponse(responseCode = "404", description = "Cadastro não encontrado!",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorMessage.class))),
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<CadastroEntity> atualizarCadastro(@PathVariable Long id,
                                                            @RequestBody CadastroEntity dadosAtualizados) {
        CadastroEntity cadastroAtualizado = cadastroService.atualizarService(id, dadosAtualizados);
        return ResponseEntity.ok(cadastroAtualizado);
    }

}
