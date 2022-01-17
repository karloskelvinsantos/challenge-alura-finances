package br.com.karloskelvin.challengealurafinances.controller;

import br.com.karloskelvin.challengealurafinances.model.Transaction;
import br.com.karloskelvin.challengealurafinances.model.TransactionType;
import br.com.karloskelvin.challengealurafinances.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/despesas")
@AllArgsConstructor
public class DespesaController {

    private TransactionService service;

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllDespesas() {
        return ResponseEntity.ok(this.service.getAllTransactions(TransactionType.EXPENSE));
    }
}
