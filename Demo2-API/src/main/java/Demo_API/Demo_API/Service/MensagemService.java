package Demo_API.Demo_API.Service;

import Demo_API.Demo_API.Repository.MensagemRepository;
import org.springframework.stereotype.Service;



@Service
public class MensagemService {

    private final MensagemRepository mensagemRepository;


    public MensagemService(MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }

    public String obterMensagem() {
        return mensagemRepository.obterMensagem();

    }
}
