package com.kata.bankaccount.port;

import com.kata.bankaccount.domain.model.Account;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    private final Map<Long, Account> accounts = new HashMap<>(); 

    public AccountRepositoryImpl() {
        // on cree le compte par défaut à 1 
        Account defaultAccount = new Account(1L);
        defaultAccount.setSoldeDuCompte(0); 
        accounts.put(defaultAccount.getAccountID(), defaultAccount);
    }

    @Override
    public void save(Account account) {
        accounts.put(account.getAccountID(), account); 
    }

    @Override
    public Optional<Account> findById(long accountID) { 
        return Optional.ofNullable(accounts.get(accountID)); 
    }

}