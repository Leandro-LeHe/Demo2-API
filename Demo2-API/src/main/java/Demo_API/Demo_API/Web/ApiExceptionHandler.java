package Demo_API.Demo_API.Web;


import Demo_API.Demo_API.exception.EntityNaoEncontrada;
import Demo_API.Demo_API.exception.UsenameUniqueViolationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler
            (UsenameUniqueViolationException.class)
    public ResponseEntity<ErrorMessage> MethodArgumentNotValidException(RuntimeException ex,
                                                                        HttpServletRequest request){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.CONFLICT, ex.getMessage()));

    }

    @ExceptionHandler
            (EntityNaoEncontrada.class)
    public ResponseEntity<ErrorMessage> EntityNaoEncontrada(RuntimeException ex,
                                                            HttpServletRequest request){

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.NOT_FOUND, ex.getMessage()));

    }


    @ExceptionHandler
            (MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> MethodArgumentNotValidException(HttpServletRequest request,
                                                                        BindingResult result) {

        //TODO:log.error("api error: ", ex); APRESENTANDO ERRO
        //TODO: não esta retornando o campo ERROR


        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request,
                        HttpStatus.UNPROCESSABLE_ENTITY,
                        "cadastro inválido", result));

    }


}
