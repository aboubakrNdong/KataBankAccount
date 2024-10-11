package com.kata.bankaccount.port;

import com.kata.bankaccount.domain.model.Account;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


@Repository
public class AccountRepositoryImpl implements AccountRepository {

     private final List<Account> accounts = new ArrayList<>();

    @Override
    public void save(Account account) {
        accounts.add(account);
    }
}