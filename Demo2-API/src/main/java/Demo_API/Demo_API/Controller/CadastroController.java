package Demo_API.Demo_API.Controller;

import Demo_API.Demo_API.DTO.DtoCadastro;
import Demo_API.Demo_API.DTO.Mapper.CadastroMapper;
import Demo_API.Demo_API.DTO.UsuarioResponseDto;
import Demo_API.Demo_API.DTO.UsuarioSenhaDto;
import Demo_API.Demo_API.Model.CadastroEntity;
import Demo_API.Demo_API.Service.CadastroService;
import Demo_API.Demo_API.Web.ErrorMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Operation(summary = "Listar todos os usuários", description = "Listar todos os usuários cadastrados",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista com todos os usuários cadastrados",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = UsuarioResponseDto.class))))
            })
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<List<UsuarioResponseDto>> listarTodos() {
        List<CadastroEntity> users = cadastroService.listarService();
        return ResponseEntity.ok(CadastroMapper.toListDto(users));
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
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN') OR hasAnyRole('ROLE_USER')")
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
   @PreAuthorize ("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<UsuarioResponseDto> salvarCadastro(@Valid @RequestBody DtoCadastro createDto) {
            CadastroEntity user = cadastroService.salvar(CadastroMapper.toUsuario(createDto));
            return ResponseEntity.status(HttpStatus.CREATED).body(CadastroMapper.toDto(user));
    }

    @Operation(summary = "Deletar cadastro",
            description = "EndPoint para deletar cadastro",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Cadastro excluído!",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Void.class))),
                    @ApiResponse(responseCode = "404", description = "Cadastro não encontrado!",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorMessage.class))),
            }
    )

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER') AND (#id == authentication.principal.id)")
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN') OR hasAnyRole('ROLE_USER')")
    public ResponseEntity<CadastroEntity> atualizarCadastro(@PathVariable Long id,
                                                            @RequestBody CadastroEntity dadosAtualizados) {
        CadastroEntity cadastroAtualizado = cadastroService.atualizarService(id, dadosAtualizados);
        return ResponseEntity.ok(cadastroAtualizado);
    }


    @Operation(summary = "Atualizar senha", description = "Atualizar senha",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Senha atualizada com sucesso",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class))),
                    @ApiResponse(responseCode = "400", description = "Senha não confere",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "404", description = "Recurso não encontrado",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "422", description = "Campos invalidos ou mal formatados",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
            })
    @PatchMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN') OR hasAnyRole('ROLE_USER')")
    public ResponseEntity<Void> updatePassword(@PathVariable Long id, @Valid @RequestBody UsuarioSenhaDto dto) {
        CadastroEntity user = cadastroService.editarSenha(id, dto.getSenhaAtual(), dto.getNovaSenha(), dto.getConfirmaSenha());
        return ResponseEntity.noContent().build();
    }

}