package softuni.exceptions.entity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class OwnedGameException extends RuntimeException {

    public OwnedGameException(String message) {
        super(message);
    }
}
