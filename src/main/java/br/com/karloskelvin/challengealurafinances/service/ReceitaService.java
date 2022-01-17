package br.com.karloskelvin.challengealurafinances.service;

import br.com.karloskelvin.challengealurafinances.model.Transaction;
import br.com.karloskelvin.challengealurafinances.model.TransactionType;
import br.com.karloskelvin.challengealurafinances.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReceitaService {

    private TransactionRepository repository;

    public List<Transaction> getAllReceitas() {
        return this.repository.findByType(TransactionType.INCOME);
    }

    public Transaction save(Transaction transaction) {
        var dataReferencia = transaction.getData();
        var dataInicial = dataReferencia.withDayOfMonth(1);
        var dataFinal = dataReferencia.withDayOfMonth(dataReferencia.lengthOfMonth());

        var transactionFinded = this.repository
                .findByDescriptionAndDataBetween(transaction.getDescription(), dataInicial, dataFinal);

        if (transactionFinded.isPresent()) {
            throw new RuntimeException("Registro já existe");
        }

        transaction.setType(TransactionType.INCOME);
        return this.repository.save(transaction);
    }
}
