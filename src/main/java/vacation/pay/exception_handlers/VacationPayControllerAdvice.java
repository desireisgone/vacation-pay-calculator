package vacation.pay.exception_handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import vacation.pay.exceptions.ParamValidationException;

@ControllerAdvice
public class VacationPayControllerAdvice {
    @ExceptionHandler(ParamValidationException.class)
    public ResponseEntity<String> handleValidationException(ParamValidationException e) {
        return ResponseEntity.status(400).body(e.getMessage());
    }
}
