package com.kata.bankaccount.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kata.bankaccount.model.Account;
import com.kata.bankaccount.model.Historique;

@Service
public class AccountService {

    private Account account = new Account();

    public void depot (double amount) {
        account.depot (amount);
    }

    public void retrait (double amount) {
        account.retrait (amount);
    }

    public List<Historique> getHistorique() {  
        return account.getHistorique();
    }


}
