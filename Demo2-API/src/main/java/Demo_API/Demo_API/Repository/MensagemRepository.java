package Demo_API.Demo_API.Repository;


import org.springframework.stereotype.Repository;

@Repository
public class MensagemRepository {


    public String obterMensagem() {
        return "mensagem do repositorio";
    }
}
