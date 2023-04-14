package uz.boom.core_project_jwt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Jarvis on Tue 11:44. 11/04/23
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ValidatorException extends RuntimeException{

    public ValidatorException(String message) {
        super(message);
    }
}
