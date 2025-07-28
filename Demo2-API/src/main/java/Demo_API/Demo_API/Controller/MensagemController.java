package Demo_API.Demo_API.Controller;

import Demo_API.Demo_API.Service.MensagemService; //interface que sera injetada
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//responde requisições REST - @Controller + @ResponseBody.
@RestController

@RequestMapping("/api")
public class MensagemController {

    // MensagemService é uma interface
    // Essa é a dependência: um objeto que sabe "obterMensagem"
    // O Spring injeta automaticamente essa dependência quando criar o controller.
    private final MensagemService mensagemService;

    // Injeção de dependência via construtor
    // Atribui a variavel criada pelo Spring dentro do construtor
    public MensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }

    @GetMapping("/mensagem")
    public String mensagem() {
        // Aqui usamos o serviço que foi injetado.
        return mensagemService.obterMensagem();

    }


}
