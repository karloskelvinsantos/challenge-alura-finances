package br.com.karloskelvin.challengealurafinances.service;

import br.com.karloskelvin.challengealurafinances.exception.TransactionNotFoundException;
import br.com.karloskelvin.challengealurafinances.model.Transaction;
import br.com.karloskelvin.challengealurafinances.repository.TransactionRepository;

public interface TransactionService {

    default boolean transactionExists(Transaction transaction, TransactionRepository repository) {
        var dataReferencia = transaction.getData();
        var dataInicial = dataReferencia.withDayOfMonth(1);
        var dataFinal = dataReferencia.withDayOfMonth(dataReferencia.lengthOfMonth());

        var transactionFinded = repository
                .findByDescriptionAndDataBetween(transaction.getDescription(), dataInicial, dataFinal);

        return transactionFinded.isPresent();
    }

    default Transaction getTransactionById(String id, TransactionRepository repository) {
        var transactionFinded = repository.findById(id);

        if (transactionFinded.isEmpty()) {
            throw new TransactionNotFoundException("Esse registro não existe.");
        }

        return transactionFinded.get();
    }

    default void deleteTransaction(String id, TransactionRepository repository) {
        repository.delete(getTransactionById(id, repository));
    }
}
