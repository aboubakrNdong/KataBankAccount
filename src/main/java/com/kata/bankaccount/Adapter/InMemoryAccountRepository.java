package com.kata.bankaccount.Adapter;

import com.kata.bankaccount.domain.Account;
import com.kata.bankaccount.port.AccountRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryAccountRepository implements AccountRepository {

    private final Map<Long, Account> accounts = new HashMap<>();
    private long nextId = 1;

    @Override
    public Optional<Account> findById(Long id) {
        return Optional.ofNullable(accounts.get(id));
    }

    @Override
    public void save(Account account) {
        if (account.getId() == null) {
            account.setId(nextId++);
        }
        accounts.put(account.getId(), account);
    }
}