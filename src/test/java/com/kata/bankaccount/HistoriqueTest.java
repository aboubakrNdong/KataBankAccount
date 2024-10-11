package com.kata.bankaccount;

import org.junit.jupiter.api.Test;

import com.kata.bankaccount.domain.model.Historique;
import com.kata.bankaccount.domain.NatureOperationEnum;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class HistoriqueTest {

    @Test
    public void should_CreateHistorique_WithCorrectValues() {
        LocalDate date = LocalDate.now();
        NatureOperationEnum nature = NatureOperationEnum.DEPOT;
        double montant = 100.0;
        double solde = 1000.0;

        Historique historique = new Historique(date, nature, montant, solde);

        assertAll("Historique Creation Assertions",
            () -> assertEquals(date, historique.getDateDeLoperation()),
            () -> assertEquals(nature, historique.getNatureOperation()),
            () -> assertEquals(montant, historique.getMontantDeLoperation()),
            () -> assertEquals(solde, historique.getSoldeDuCompte())
        );
    }
}