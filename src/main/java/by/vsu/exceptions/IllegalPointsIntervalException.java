package by.vsu.exceptions;

public class IllegalPointsIntervalException extends ApiException {

    public IllegalPointsIntervalException() {
        super("Введены неверные координаты отрезков!");
    }

}
