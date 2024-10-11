package com.kata.bankaccount.domain.model;

import com.kata.bankaccount.domain.NatureOperationEnum;

import java.time.LocalDate;

public class  Historique {
    
    private final LocalDate dateDeLoperation;
    private final NatureOperationEnum natureDeLoperation;
    private final double montantDeLoperation;
    private final double soldeDuCompte;
   

    public Historique(LocalDate dateDeLoperation, NatureOperationEnum natureDeLoperation, double montantDeLoperation, double soldeDuCompte) {
        this.dateDeLoperation = dateDeLoperation;
        this.natureDeLoperation = natureDeLoperation;
        this.montantDeLoperation = montantDeLoperation;
        this.soldeDuCompte = soldeDuCompte;
    }

    public LocalDate getDateDeLoperation() {
        return dateDeLoperation;
    }

    public double getMontantDeLoperation() {
        return montantDeLoperation;
    }

    public double getSoldeDuCompte() {
        return soldeDuCompte;
    }

    public NatureOperationEnum getNatureOperation() {
        return natureDeLoperation;
    }
}
