package Demo_API.Demo_API.Service;


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

    // Optional: pode retornar ou não uma lista
    public AssistidosEntity buscarOuFalharService(Long id) {
        return assistidosRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cadastro não encontrado"));

    }

    public AssistidosEntity salvarService(AssistidosEntity assistido) {
        return assistidosRepository.save(assistido);
    }
    public void deletarService(Long id) {
        assistidosRepository.deleteById(id);
    }

    public AssistidosEntity atualizarAssistido(Long id, AssistidosEntity dadosNovos) {
        try {
            AssistidosEntity existente = buscarOuFalharService(id);

            // Atualiza os campos (exemplo, ajuste para seus campos reais)
            existente.setNome(dadosNovos.getNome());
            existente.setEmail(dadosNovos.getEmail());
            return assistidosRepository.save(existente);
        }catch (Exception e) {
            System.out.println("Erro ao atualizar assistido");
            throw new EntityNotFoundException("Erro ao atualizar assistido");
        }
    }


/*

    // Atualizar um usuário existente
    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setNome(usuarioAtualizado.getNome());
                    usuario.setEmail(usuarioAtualizado.getEmail());
                    return usuarioRepository.save(usuario);
                })
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + id));
    }
*/


}

