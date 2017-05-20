package by.vsu.exceptions;

public class StabilityConditionException extends ApiException {

    public StabilityConditionException() {
        super("Не выполняется условие устойчивости!");
    }

}
