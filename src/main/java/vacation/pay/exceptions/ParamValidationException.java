package vacation.pay.exceptions;

public class ParamValidationException extends RuntimeException {
    public ParamValidationException() {
        super("Неверные входные данные");
    }
}
