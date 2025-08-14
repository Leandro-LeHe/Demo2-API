package Demo_API.Demo_API.Model;

//ENTIDADE DO BANCO DE DADOS
//notação JPA

import jakarta.annotation.Resource;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import java.io.Serializable;


@Entity //indica que é uma entidade
@Table(name="Tabela-Assistidos")  // username da tabela

public class CadastroEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "username não pode ser vazio")
    @Size(max = 50)
    @Column(unique = true)
    private String username;


    //@Column(unique = true)
    private String senha;

    @NotBlank(message = "Email não pode ser vazio")
    @Email(message = "Email não pode ser inválido")
    @Size(max = 50)
    private String email;

    @NotBlank(message = "endereco não pode ser vazio")
    @Size(max = 50)
    private String endereco;


    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private Role role;

    public Resource getRole() {
            return null;
    }

    public enum Role {
        ROLE_ADMIN, ROLE_USER
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // mesma referência
        if (o == null || getClass() != o.getClass()) return false; // tipos diferentes
        CadastroEntity that = (CadastroEntity) o;
        return id != null && id.equals(that.id); // compara pelo id
    }

    @Override
    public int hashCode() {
        return 31; // valor fixo enquanto id é null (evita problemas no Hibernate)
    }

    @Override
    public String toString() {
        return "CadastroEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }




    public CadastroEntity() {
        this.role = Role.ROLE_USER;
    }


    public CadastroEntity(Long id, String username, String senha, String email, String endereco) {
        this.id = id;
        this.username = username;
        this.senha = senha;
        this.email = email;
        this.endereco = endereco;
    }


    public Long getId() {
        return id;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
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