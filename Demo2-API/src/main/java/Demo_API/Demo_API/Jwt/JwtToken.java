package Demo_API.Demo_API.Jwt;

public class JwtToken {
    private String token;

    // Construtor padrão
    public JwtToken() {
    }

    // Construtor com parâmetro
    public JwtToken(String token) {
        this.token = token;
    }

    // Getter
    public String getToken() {
        return token;
    }

    // Setter
    public void setToken(String token) {
        this.token = token;
    }
}


