package softuni.areas.users.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OwnedGameException extends RuntimeException {

    public OwnedGameException(String message) {
        super(message);
    }
}
