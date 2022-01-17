package br.com.karloskelvin.challengealurafinances.service;

import br.com.karloskelvin.challengealurafinances.model.Transaction;
import br.com.karloskelvin.challengealurafinances.model.TransactionType;
import br.com.karloskelvin.challengealurafinances.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DespesaService {

    private TransactionRepository repository;

    public List<Transaction> getAllDespesas() {
        return this.repository.findByType(TransactionType.EXPENSE);
    }
}
