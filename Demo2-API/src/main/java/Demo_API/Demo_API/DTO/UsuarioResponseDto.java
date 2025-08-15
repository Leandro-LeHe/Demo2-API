package Demo_API.Demo_API.DTO;

public class UsuarioResponseDto {
    private Long id;
    private String username;
    private String role;

    public UsuarioResponseDto() {
    }

    public UsuarioResponseDto(Long id, String username, String role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
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
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}