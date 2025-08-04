package Demo_API.Demo_API.Service;


import Demo_API.Demo_API.DTO.DtoResponse;
import Demo_API.Demo_API.Model.AssistidosEntity;
import Demo_API.Demo_API.Repository.AssistidosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssistidosService {

    private final AssistidosRepository assistidosRepository;

    public AssistidosService(AssistidosRepository assistidosRepository) {
        this.assistidosRepository = assistidosRepository;

    }

    public List<AssistidosEntity> listarService() {
        return assistidosRepository.findAll();
    }

    public AssistidosEntity buscarOuFalharService(Long id) {
        return assistidosRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cadastro não encontrado"));

    }

    public AssistidosEntity salvarService(AssistidosEntity assistido) {
        return assistidosRepository.save(assistido);
    }

    public void deletarService(Long id) {
        assistidosRepository.deleteById(id);
    }


    public AssistidosEntity atualizarService(Long id, AssistidosEntity dadosAtualizados) {
        // Busca o registro existente, ou lança exceção se não encontrar
        AssistidosEntity existente = buscarOuFalharService(id);

        // Atualiza os campos (exemplo: nome, cpf, etc. — você pode ajustar conforme sua entidade)
        //Lombok dando erro
        existente.setNome(dadosAtualizados.getNome());
        existente.setEmail(dadosAtualizados.getEmail());
        existente.setEndereco(dadosAtualizados.getEndereco());
        // adicione outros campos conforme a sua entidade

        // Salva e retorna o objeto atualizado
        return assistidosRepository.save(existente);
    }
    /*
     //DTO para Entity
     public static DtoResponse paraEntity (AssistidosEntity entity) {
        return new DtoResponse(
                entity.getNome(),
                entity.getEmail(),
                entity.getEndereco()
        );
    }
    */
}