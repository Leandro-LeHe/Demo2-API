package Demo_API.Demo_API.DTO;

public class UsuarioResponseDto {
    private Long id;
    private String nome;
    private String role;

    public UsuarioResponseDto() {
    }

    public UsuarioResponseDto(Long id, String nome, String role) {
        this.id = id;
        this.nome = nome;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role = role;
    }


    @Override
    public String toString() {
        return "UsuarioResponseDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}