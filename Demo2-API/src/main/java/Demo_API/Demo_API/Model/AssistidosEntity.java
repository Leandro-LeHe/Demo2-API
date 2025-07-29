package Demo_API.Demo_API.Model;

//ENTIDADE DO BANCO DE DADOS
//notação JPA

import jakarta.persistence.*;

@Entity //indica que é uma entidade
@Table(name="Tabela-Assistidos")  // nome da tabela

public class AssistidosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;
    
    private String nome;
    private String email;

    public AssistidosEntity(String nome, String email){
        this.nome = nome;
        this.email = email;
    }

    //Construtor vazio (sem Lombok)
    public AssistidosEntity() {

    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
}
