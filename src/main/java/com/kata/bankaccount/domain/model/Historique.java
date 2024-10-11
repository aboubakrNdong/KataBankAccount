package com.kata.bankaccount.domain.model;

import com.kata.bankaccount.domain.NatureOperationEnum;

import java.time.LocalDate;

public record Historique(
    LocalDate dateDeLoperation,
    NatureOperationEnum natureDeLoperation,
    double montantDeLoperation,
    double soldeDuCompte
) {
}
