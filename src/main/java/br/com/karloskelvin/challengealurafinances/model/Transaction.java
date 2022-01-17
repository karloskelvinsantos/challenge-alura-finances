package br.com.karloskelvin.challengealurafinances.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transaction {

    @Id
    private String id;
    private String description;
    private BigDecimal value;
    private LocalDate data;
    @JsonIgnore
    private TransactionType type;

}
