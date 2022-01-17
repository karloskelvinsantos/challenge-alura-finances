package br.com.karloskelvin.challengealurafinances.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum TransactionType {
    EXPENSE("EXPENSE"), INCOME("INCOME");

    private String description;

}
