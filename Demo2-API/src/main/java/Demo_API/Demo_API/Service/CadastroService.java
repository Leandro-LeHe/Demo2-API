package Demo_API.Demo_API.Service;


import Demo_API.Demo_API.Model.CadastroEntity;
import Demo_API.Demo_API.Repository.CadastroRepository;
import Demo_API.Demo_API.exception.EntityNaoEncontrada;
import Demo_API.Demo_API.exception.UsenameUniqueViolationException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroService {

    private final CadastroRepository cadastroRepository;

    public CadastroService(CadastroRepository cadastroRepository) {
        this.cadastroRepository = cadastroRepository;

    }

    public List<CadastroEntity> listarService() {
        return cadastroRepository.findAll();
    }
    @Transactional
    public CadastroEntity buscarOuFalharService(Long id) {

        return cadastroRepository.findById(id).orElseThrow(
                () -> new EntityNaoEncontrada(String.format ("ID %s não encontrado", id)));

    }

    public CadastroEntity salvarService(CadastroEntity user) {
        try {//TODO: nao esta encontrando o erro
            return cadastroRepository.save(user);
        }   catch (org.springframework.dao.DataIntegrityViolationException ex) {
            throw new UsenameUniqueViolationException(String.format("Nome %s já cadastrado!", user.getNome()));
        }
    }


    public void deletarService(Long id) {
        cadastroRepository.deleteById(id);
    }


    public CadastroEntity atualizarService(Long id, CadastroEntity dadosAtualizados) {

        CadastroEntity existente = buscarOuFalharService(id);

        // Atualiza os campos (exemplo: nome, cpf, etc. — você pode ajustar conforme sua entidade)
        //Lombok dando erro
        existente.setNome(dadosAtualizados.getNome());
        existente.setEmail(dadosAtualizados.getEmail());
        existente.setEndereco(dadosAtualizados.getEndereco());

        try {   //TODO: noa esta pegando o erro

            return cadastroRepository.save(existente);
        } catch (org.springframework.dao.DataIntegrityViolationException ex) {
            throw new UsenameUniqueViolationException(String.format("Nome %s já cadastrado!", existente.getNome()));
        }

    }
    @Transactional
    public CadastroEntity editarSenha(Long id, String senha) {
        CadastroEntity user = buscarOuFalharService(id);
        user.setSenha(senha);
        return user;
    }
}