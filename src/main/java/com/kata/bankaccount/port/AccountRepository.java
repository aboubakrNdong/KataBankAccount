package com.kata.bankaccount.port;


import com.kata.bankaccount.domain.Account;
import java.util.Optional;

public interface AccountRepository {
    Optional<Account> findById(Long id);
    void save(Account account);
}