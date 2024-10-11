package com.kata.bankaccount.port;


import com.kata.bankaccount.domain.model.Account;

public interface AccountRepository {
    void save(Account account);
}