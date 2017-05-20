package by.vsu.exceptions;

public class SolutionNotFoundException extends ApiException {

    public SolutionNotFoundException() {
        super("Решение не найдено!");
    }
}
