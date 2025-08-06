package Demo_API.Demo_API.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor // obrigatório para ModelMapper funcionar
@AllArgsConstructor
public class DtoCadastro {
    private String nome;
    private String email;
    private String endereco;
}

