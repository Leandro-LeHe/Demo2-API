package Demo_API.Demo_API.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor // obrigatório para ModelMapper funcionar
@AllArgsConstructor
public class DtoCadastro {
    private Long id;
    private String nome;
    private String email;
    private String endereco;
    private String senha;
}

