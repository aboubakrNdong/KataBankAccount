package com.kata.bankaccount.app;


import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.kata.bankaccount.domain.Account;
import com.kata.bankaccount.domain.Historique;

import java.util.List;


@Service
    public interface AccountService {
        void depot(double montant);
        void retrait( double montant);
        List<Historique> getHistorique();
        double getsoldeDuCompte();
    }

    
   /*  private final Account account = new Account();

    @Transactional
    public void depot (double montant) {
        account.depot (montant);
    }
    
    @Transactional
    public void retrait (double montant) {
        account.retrait (montant);
    }

    public List<Historique> getHistorique() {  
        return account.getHistorique();
    }
    public double getsoldeDuCompte() {
        return account.getsoldeDuCompte();
    } */

