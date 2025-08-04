package Demo_API.Demo_API.DTO;

import lombok.Getter;
import lombok.Setter;

public class DtoResponse {



   @Getter @Setter
    private String nome;
    private String email;
    private String endereco;

    public DtoResponse (String nome, String email, String endereco) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
    }


}

