package br.com.karloskelvin.challengealurafinances.exception;

public class TransactionExistsException extends RuntimeException {

    public TransactionExistsException(String message) {
        super(message);
    }
}
