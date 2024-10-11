package com.kata.bankaccount.app.service.impl;

import com.kata.bankaccount.app.AccountService;
import com.kata.bankaccount.domain.NatureOperationEnum;
import com.kata.bankaccount.domain.model.Account;
import com.kata.bankaccount.domain.model.Historique;
import com.kata.bankaccount.port.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.kata.bankaccount.domain.util.Constantes.*;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void depot(long accountID, double montant) {
        validateMontant(montant);
        Account account = getAccountById(accountID);
        account.setSoldeDuCompte(account.getSoldeDuCompte() + montant);
        account.getHistoriques().add(new Historique(LocalDate.now(), NatureOperationEnum.DEPOT, montant, account.getSoldeDuCompte()));
        accountRepository.save(account);
    }

    @Override
    public void retrait(long accountID, double montant) {
        validateMontant(montant);
        Account account = getAccountById(accountID);
        if (montant > account.getSoldeDuCompte()) {
            throw new IllegalArgumentException(SOLDE_INSUFFISANT);
        }
        account.setSoldeDuCompte(account.getSoldeDuCompte() - montant);
        account.getHistoriques().add(new Historique(LocalDate.now(), NatureOperationEnum.RETRAIT, -montant, account.getSoldeDuCompte()));
        accountRepository.save(account);
    }

    @Override
    public List<Historique> getHistorique(long accountID) {
        Account account = getAccountById(accountID);
        if (account.getHistoriques().isEmpty()) {
            throw new IllegalArgumentException(HISTORIQUE_VIDE);
        }
        return account.getHistoriques();
    }

    @Override
    public double getSoldeDuCompte(long accountID) {
        return getAccountById(accountID).getSoldeDuCompte();
    }

    private Account getAccountById(long accountID) {
        Optional<Account> account = accountRepository.findById(accountID);
        if (account.isEmpty()) {
            return accountRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("Default account not found"));
        }
        return account.get();
    }

    private void validateMontant(double montant) {
        if (montant <= 0) {
            throw new IllegalArgumentException(MONTANT_POSITIF);
        }
    }
}