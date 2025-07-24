package exceptions;

public class ApiException extends Exception {
    public ApiException(String message) {
        super("Error de API: " + message);
    }
}
