package Demo_API.Demo_API.DTO;

public class UsuarioResponseDto {
    private Long id;
    private String nome;

    public UsuarioResponseDto() {
    }

    public UsuarioResponseDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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

    @Override
    public String toString() {
        return "UsuarioResponseDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}