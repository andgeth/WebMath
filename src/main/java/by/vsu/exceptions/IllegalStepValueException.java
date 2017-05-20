package by.vsu.exceptions;

public class IllegalStepValueException extends ApiException {

    public IllegalStepValueException() {
        super("Шаг введен некорректно!");
    }

}
