package EcoBackEnd.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClientNotFoundExeption extends RuntimeException {

    public ClientNotFoundExeption(String mensaje){
        super(mensaje);
    }
}
