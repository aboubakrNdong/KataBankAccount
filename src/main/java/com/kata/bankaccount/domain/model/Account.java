package com.kata.bankaccount.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private final long accountID;
    private double soldeDuCompte;
    private final List<Historique> historiques;

    public Account(long accountID) {
        this.accountID = accountID;
        this.soldeDuCompte = 0;
        this.historiques = new ArrayList<>();
    }

    public long getAccountID() {
        return accountID;
    }

    public double getSoldeDuCompte() {
        return this.soldeDuCompte;
    }

    public List<Historique> getHistoriques() {
        return historiques;
    }

    public void setSoldeDuCompte(double soldeDuCompte) {
        this.soldeDuCompte = soldeDuCompte;
    }
}
