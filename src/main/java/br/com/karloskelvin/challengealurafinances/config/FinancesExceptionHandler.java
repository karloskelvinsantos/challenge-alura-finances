package br.com.karloskelvin.challengealurafinances.config;

import br.com.karloskelvin.challengealurafinances.exception.TransactionExistsException;
import br.com.karloskelvin.challengealurafinances.exception.TransactionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class FinancesExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TransactionExistsException.class)
    protected ResponseEntity<String> handleTransactionExistsException(RuntimeException runtimeException) {
        return new ResponseEntity<>(runtimeException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TransactionNotFoundException.class)
    protected ResponseEntity<String> handleTransactionNotFoundException(RuntimeException runtimeException) {
        return new ResponseEntity<>(runtimeException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
