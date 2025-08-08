package Demo_API.Demo_API.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.Email;

@Getter
@Setter
@NoArgsConstructor // obrigatório para ModelMapper funcionar
@AllArgsConstructor
public class DtoCadastro {

    @NotBlank(message = "Nome não pode ser vazio")
    @Size(max = 50)
    @Column(unique = true)
    private String nome;

    @NotBlank(message = "Email não pode ser vazio")
    @Email(message = "Email não pode ser inválido")
    private String email;

    @NotBlank(message = "endereco não pode ser vazio")
    @Size(max = 50)
    private String endereco;
}

