package com.kata.bankaccount.port;


import com.kata.bankaccount.domain.model.Account;
import java.util.Optional;

public interface AccountRepository {
    void save(Account account);
    Optional<Account> findById(long accountID);
}