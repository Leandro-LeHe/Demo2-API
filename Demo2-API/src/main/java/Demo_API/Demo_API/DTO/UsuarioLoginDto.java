package Demo_API.Demo_API.DTO;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class UsuarioLoginDto {

    private String username;
    private String password;


    public String getNome() {
        return username;
    }

    public void setNome(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String senha) {
        this.password = senha;
    }

}
