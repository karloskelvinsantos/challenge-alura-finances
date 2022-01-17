package br.com.karloskelvin.challengealurafinances.repository;

import br.com.karloskelvin.challengealurafinances.model.Transaction;
import br.com.karloskelvin.challengealurafinances.model.TransactionType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends MongoRepository<Transaction, String> {

    List<Transaction> findByType(TransactionType type);
    Optional<Transaction> findByDescriptionAndDataBetween(String Description, LocalDate dataInicio, LocalDate dataFim);
}
