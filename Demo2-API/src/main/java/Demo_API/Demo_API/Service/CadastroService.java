package Demo_API.Demo_API.Service;


import Demo_API.Demo_API.Jwt.JwtUserDetailsService;
import Demo_API.Demo_API.Model.CadastroEntity;
import Demo_API.Demo_API.Repository.CadastroRepository;
import Demo_API.Demo_API.exception.EntityNaoEncontrada;
import Demo_API.Demo_API.exception.PasswordInvalidException;
import Demo_API.Demo_API.exception.UsenameUniqueViolationException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CadastroService {

    private final CadastroRepository cadastroRepository;
    private final PasswordEncoder passwordEncoder;


    public class AuthService {

        private final JwtUserDetailsService detailsService;
        private final AuthenticationManager authenticationManager;

        public AuthService(JwtUserDetailsService detailsService,
                           AuthenticationManager authenticationManager) {
            this.detailsService = detailsService;
            this.authenticationManager = authenticationManager;
        }
    }



    public CadastroService(CadastroRepository cadastroRepository, PasswordEncoder passwordEncoder) {
        this.cadastroRepository = cadastroRepository;

        this.passwordEncoder = passwordEncoder;
    }

    public List<CadastroEntity> listarService() {
        return cadastroRepository.findAll();
    }

    @Transactional
    public CadastroEntity buscarOuFalharService(Long id) {

        return cadastroRepository.findById(id).orElseThrow(
                () -> new EntityNaoEncontrada(String.format("ID %s não encontrado", id)));

    }

    public CadastroEntity salvar(CadastroEntity usuario) {
        try {
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            return cadastroRepository.save(usuario);
        } catch (org.springframework.dao.DataIntegrityViolationException ex) {
            throw new UsenameUniqueViolationException(String.format("Username '%s' já cadastrado", usuario.getusername()));
        }
    }


    public void deletarService(Long id) {
        cadastroRepository.deleteById(id);
    }


    public CadastroEntity atualizarService(Long id, CadastroEntity dadosAtualizados) {

        CadastroEntity existente = buscarOuFalharService(id);

        // Atualiza os campos (exemplo: nome, cpf, etc. — você pode ajustar conforme sua entidade)
        //Lombok dando erro
        existente.setusername(dadosAtualizados.getusername());
        existente.setEmail(dadosAtualizados.getEmail());
        existente.setEndereco(dadosAtualizados.getEndereco());

        try {   //TODO: noa esta pegando o erro

            return cadastroRepository.save(existente);
        } catch (org.springframework.dao.DataIntegrityViolationException ex) {
            throw new UsenameUniqueViolationException(String.format("Nome %s já cadastrado!", existente.getusername()));
        }

    }

    @org.springframework.transaction.annotation.Transactional
    public CadastroEntity editarSenha(Long id, String senhaAtual, String novaSenha, String confirmaSenha) {
        if (!novaSenha.equals(confirmaSenha)) {
            throw new PasswordInvalidException("Nova senha não confere com confirmação de senha.");
        }

        CadastroEntity user = buscarOuFalharService(id);
        if (!passwordEncoder.matches(senhaAtual, user.getSenha())) {
            throw new PasswordInvalidException("Sua senha não confere.");
        }

        user.setSenha(passwordEncoder.encode(novaSenha));
        return user;
    }

    @Transactional
    public CadastroEntity buscarPorUsername(String username) {
        return cadastroRepository.findByUsername(username).orElseThrow(
                () -> new EntityNaoEncontrada(String.format("Usuario com %s não encontrado", username)));
    }


    public CadastroEntity.Role buscarRolePorUsername(String nome) {
        return cadastroRepository.findRoleByNome(nome);
    }


}