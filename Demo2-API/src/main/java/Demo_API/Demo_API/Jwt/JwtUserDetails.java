package Demo_API.Demo_API.Jwt;

import Demo_API.Demo_API.Model.CadastroEntity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class JwtUserDetails extends User {

    private CadastroEntity usuario;

    public JwtUserDetails(CadastroEntity usuario) {
        super(usuario.getusername(), usuario.getSenha(), AuthorityUtils.createAuthorityList(usuario.getRole().name()));
        this.usuario = usuario;
    }

    public Long getId() {
        return this.usuario.getId();
    }

    public String getRole() {
        return this.usuario.getRole().name();
    }
}

