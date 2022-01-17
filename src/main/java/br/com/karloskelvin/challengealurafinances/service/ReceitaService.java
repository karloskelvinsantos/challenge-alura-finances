package br.com.karloskelvin.challengealurafinances.service;

import br.com.karloskelvin.challengealurafinances.exception.TransactionExistsException;
import br.com.karloskelvin.challengealurafinances.model.Transaction;
import br.com.karloskelvin.challengealurafinances.model.TransactionType;
import br.com.karloskelvin.challengealurafinances.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@AllArgsConstructor
public class ReceitaService implements TransactionService {

    private MessageSource messageSource;
    private TransactionRepository repository;

    public List<Transaction> getAllReceitas() {
        return this.repository.findByType(TransactionType.INCOME);
    }

    public Transaction save(Transaction transaction) {

        if (transactionExists(transaction, this.repository)) {
            throw new TransactionExistsException("Registro já existe com a descrição informada para o mês enviado.");
        }

        transaction.setType(TransactionType.INCOME);
        return this.repository.save(transaction);
    }

    public Transaction getReceitaById(String id) {
        return getTransactionById(id, this.repository);
    }

    public void delete(String id) {
        deleteTransaction(id, this.repository);
    }
}
