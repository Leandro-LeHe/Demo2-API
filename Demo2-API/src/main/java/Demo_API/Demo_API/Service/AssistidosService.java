package Demo_API.Demo_API.Service;


import Demo_API.Demo_API.Model.AssistidosEntity;
import Demo_API.Demo_API.Repository.AssistidosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssistidosService {
    private final AssistidosRepository assistidosRepository;

    public AssistidosService(AssistidosRepository assistidosRepository) {
        this.assistidosRepository = assistidosRepository;

    }

    public List<AssistidosEntity> listarAssistidos() {
        return assistidosRepository.findAll();
    }

    // Optional: pode retornar ou não uma lista
    public Optional<AssistidosEntity> buscarPorid(Long id) {
        return assistidosRepository.findById(id);
    }

    public AssistidosEntity salvarAssistido(AssistidosEntity assistido) {
        return assistidosRepository.save(assistido);
    }
    public void deletarAssistido(Long id) {
        assistidosRepository.deleteById(id);
    }


}

