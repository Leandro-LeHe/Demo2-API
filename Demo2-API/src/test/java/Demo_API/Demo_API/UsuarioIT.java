package Demo_API.Demo_API;

import Demo_API.Demo_API.DTO.DtoCadastro;
import Demo_API.Demo_API.DTO.UsuarioResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = "/sql/usuarios/usuarios-insert.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "/sql/usuarios/usuarios-delete.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)

public class UsuarioIT {


    @Autowired
    WebTestClient webTestClient;

    @Test
    public void CriarUsuarioComStatus201(){
        UsuarioResponseDto responseBody = webTestClient
                .post()
                .uri("/assistidos")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new DtoCadastro("nomeTeste","Teste@gmail.com"))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(UsuarioResponseDto.class)
                .returnResult().getResponseBody();


        org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull(); // testar se o retorno não é nulo
        org.assertj.core.api.Assertions.assertThat(responseBody.getId()).isNotNull();
        org.assertj.core.api.Assertions.assertThat(responseBody.getNome()).isEqualTo("nomeTeste");
    }
}
