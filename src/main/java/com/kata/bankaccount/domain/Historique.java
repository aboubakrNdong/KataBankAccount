package com.kata.bankaccount.domain;

import java.time.LocalDate;

public class  Historique {
    
    private final LocalDate dateDeDepot;
    private final double montantDepose;
    private final double soldeDuCompte;

    public Historique(LocalDate dateDeDepot, double montantDepose, double soldeDuCompte) {
        this.dateDeDepot = dateDeDepot;
        this.montantDepose = montantDepose;
        this.soldeDuCompte = soldeDuCompte;
    }

    public LocalDate getDateDeDepot() {
        return dateDeDepot;
    }

    public double getMontantDepose() {
        return montantDepose;
    }

    public double getSoldeDuCompte() {
        return soldeDuCompte;
    }
}
