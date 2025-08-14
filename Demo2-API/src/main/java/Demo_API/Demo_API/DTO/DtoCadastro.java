package Demo_API.Demo_API.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor // obrigatório para o Jackson e ModelMapper
@AllArgsConstructor
public class DtoCadastro {

    @NotBlank(message = "Nome não pode ser vazio")
    @Size(max = 50)
    @Column(unique = true)
    private String nome;

    private String senha;

    @NotBlank(message = "Email não pode ser vazio")
    private String email;

    @NotBlank(message = "Endereço não pode ser vazio")
    @Size(max = 50)
    private String endereco;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


}
