package Demo_API.Demo_API.Model;

//ENTIDADE DO BANCO DE DADOS
//notação JPA

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import java.io.Serializable;


@Entity //indica que é uma entidade
@Table(name="Tabela-Assistidos")  // nome da tabela

public class CadastroEntity implements Serializable {
    //TODO:  @JsonIgnore  @JsonIgnoreProperties(ignoreUnknown = true) por que não usar?
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome não pode ser vazio")
    @Size(max = 50)
    @Column(unique = true)
    private String nome;

   @NotBlank(message = "Email não pode ser vazio")
    @Email(message = "Email não pode ser inválido")
    @Size(max = 50)
    private String email;

    @NotBlank(message = "endereco não pode ser vazio")
    @Size(max = 50)
    private String endereco;

    public CadastroEntity() {
    }

    public CadastroEntity(Long id, String nome, String email, String endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
    }

    public CadastroEntity(String nomeTeste, String mail) {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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