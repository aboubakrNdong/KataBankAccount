package com.kata.bankaccount.domain.model;

import com.kata.bankaccount.domain.NatureOperationEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.kata.bankaccount.domain.util.Constantes.*;


public class Account  {
   
    private double soldeDuCompte;
    private final List<Historique> historiques;

    public Account() {
        this.soldeDuCompte = 0;
        this.historiques = new ArrayList<>();
    }

    public void depot(double montant) {
        validateMontant(montant);
        this.soldeDuCompte += montant;
        historiques.add(new Historique(LocalDate.now(), NatureOperationEnum.DEPOT, montant, this.soldeDuCompte));
    }

    public void retrait (double montant) {
        validateMontant(montant);
        if (montant > this.soldeDuCompte) {
            throw new IllegalArgumentException(SOLDE_INSUFFISANT);
        }
        this.soldeDuCompte -= montant;
        historiques.add(new Historique(LocalDate.now(), NatureOperationEnum.RETRAIT, -montant, this.soldeDuCompte));
    }

    public List<Historique> getHistorique() {

        if(historiques.isEmpty()){
            throw new IllegalArgumentException(HISTORIQUE_VIDE);
        }

        return new ArrayList<>(historiques);
    }

    public double getSoldeDuCompte() {
        return this.soldeDuCompte;
    }

    private void validateMontant(double montant) {
        if (montant <= 0) {
            throw new IllegalArgumentException(MONTANT_POSITIF);
        }
    }

}
