package by.vsu.exceptions;

public class ApiException extends RuntimeException {

    protected String message;

    public ApiException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
