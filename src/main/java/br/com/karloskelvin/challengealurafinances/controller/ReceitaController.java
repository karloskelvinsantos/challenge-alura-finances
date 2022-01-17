package br.com.karloskelvin.challengealurafinances.controller;

import br.com.karloskelvin.challengealurafinances.model.Transaction;
import br.com.karloskelvin.challengealurafinances.service.ReceitaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receitas")
@AllArgsConstructor
public class ReceitaController {

    private ReceitaService service;

    @PostMapping
    public ResponseEntity<Transaction> create(@RequestBody Transaction transaction) {
        return new ResponseEntity<>(this.service.save(transaction), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAll() {
        return ResponseEntity.ok(this.service.getAllReceitas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getOne(@PathVariable String id) {
        return ResponseEntity.ok(this.service.getReceitaById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        this.service.delete(id);
        return ResponseEntity.ok().build();
    }
}
