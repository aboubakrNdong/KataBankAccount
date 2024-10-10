package com.kata.bankaccount.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Account {
    private double balance;
    private final List<Historique> historiques;

    public Account() {
        this.balance = 0;
        this.historiques = new ArrayList<>();
    }

    public void depot(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        this.balance += amount;
        historiques.add(new Historique(LocalDate.now(), amount, this.balance));
    }

    public void retrait (double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > this.balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        this.balance -= amount;
        historiques.add(new Historique(LocalDate.now(), -amount, this.balance));
    }

    public List<Historique> getHistorique() {
        return new ArrayList<>(historiques);
    }

    public double getBalance() {
        return this.balance;
    }


}
