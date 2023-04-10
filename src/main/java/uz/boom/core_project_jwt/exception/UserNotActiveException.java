package uz.boom.core_project_jwt.exception;

public class UserNotActiveException extends RuntimeException {

    public UserNotActiveException(String message) {
        super(message);
    }

    public UserNotActiveException() {
        super("User not active!");
    }
}
