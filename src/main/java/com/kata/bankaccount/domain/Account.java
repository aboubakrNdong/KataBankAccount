package com.kata.bankaccount.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Account {
    private Long id;
    private double soldeDuCompte;
    private final List<Historique> historiques;

    public Account() {
        this.soldeDuCompte = 0;
        this.historiques = new ArrayList<>();
    }

    public void depot(double montant) {
        validateMontant(montant);
        this.soldeDuCompte += montant;
        historiques.add(new Historique(LocalDate.now(), montant, this.soldeDuCompte));
    }

    public void retrait (double montant) {
        validateMontant(montant);
        if (montant > this.soldeDuCompte) {
            throw new IllegalArgumentException("soldeDuCompte insufisant");
        }
        this.soldeDuCompte -= montant;
        historiques.add(new Historique(LocalDate.now(), -montant, this.soldeDuCompte));
    }

    public List<Historique> getHistorique() {
        return new ArrayList<>(historiques);
    }

    public double getsoldeDuCompte() {
        return this.soldeDuCompte;
    }

    private void validateMontant(double montant) {
        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant doit être positif");
        }
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
