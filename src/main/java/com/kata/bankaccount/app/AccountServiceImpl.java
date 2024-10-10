package com.kata.bankaccount.app;

import com.kata.bankaccount.domain.Account;
import com.kata.bankaccount.domain.Historique;
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

    public List<Historique> getHistorique() {
        return account.getHistorique();
    }

    public double getsoldeDuCompte() {
        return account.getsoldeDuCompte();
    }
}