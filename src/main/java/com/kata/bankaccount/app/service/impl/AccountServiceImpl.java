package com.kata.bankaccount.app.service.impl;

import com.kata.bankaccount.app.AccountService;
import com.kata.bankaccount.domain.model.Account;
import com.kata.bankaccount.domain.model.Historique;
import com.kata.bankaccount.port.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    private final Account account = new Account();

    //@Transactional
    public void depot( double montant) {        
        account.depot(montant);
        accountRepository.save(account);
    }

    //@Transactional
    public void retrait( double montant) {
        account.retrait(montant);
        accountRepository.save(account);
    }

    @Override
    public List<Historique> getHistorique() {
        return account.getHistorique();
    }

    @Override
    public double getSoldeDuCompte() {
        return account.getSoldeDuCompte();
    }
}