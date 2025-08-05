package Demo_API.Demo_API.Model;

//ENTIDADE DO BANCO DE DADOS
//notação JPA

import jakarta.persistence.*;


@Entity //indica que é uma entidade
@Table(name="Tabela-Assistidos")  // nome da tabela

public class CadastroEntity {
    //TODO:  @JsonIgnore  @JsonIgnoreProperties(ignoreUnknown = true) por que não usar?
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String endereco;


    public CadastroEntity(Long id, String nome, String email, String endereco, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
    }

    //Construtor vazio
    public CadastroEntity() {}
    public Long getId() {return id;}
    public String getEmail() {return email;}
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


}