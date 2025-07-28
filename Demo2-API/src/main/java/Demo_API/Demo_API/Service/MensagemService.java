package Demo_API.Demo_API.Service;


import Demo_API.Demo_API.Repository.MensagemRepository;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {

    // MensagemRepository vai fazer o mapeamento do repositorio
    // MensagemRepository NÂO é instanciado manualmente
    private final MensagemRepository mensagemRepository;

    //Variavel instanciada dentro do construtor
    public MensagemService(MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }

    public String obterMensagem() {
        return mensagemRepository.obterMensagem();

    }
}
