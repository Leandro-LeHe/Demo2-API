package Demo_API.Demo_API.Service;


import Demo_API.Demo_API.Model.CadastroEntity;
import Demo_API.Demo_API.Repository.CadastroRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public CadastroEntity buscarOuFalharService(Long id) {

        return cadastroRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cadastro não encontrado"));

    }

    public CadastroEntity salvarService(CadastroEntity x) {
        return cadastroRepository.save(x);
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

        return cadastroRepository.save(existente);
    }

}