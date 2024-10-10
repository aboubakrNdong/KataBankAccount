package com.kata.bankaccount.model;

import java.time.LocalDate;

public class  Historique {
    private final LocalDate date;
    private final double amount;
    private final double balance;

    public Historique(LocalDate date, double amount, double balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }
}