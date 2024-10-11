package com.kata.bankaccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.kata.bankaccount.app.AccountService;
import com.kata.bankaccount.app.service.impl.AccountServiceImpl;
import com.kata.bankaccount.domain.model.Account;
import com.kata.bankaccount.domain.model.Historique;
import com.kata.bankaccount.port.AccountRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

public class AccountTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService = new AccountServiceImpl();

    private Account account;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        account = new Account(1L); // Create an account with ID 1
        when(accountRepository.findById(1L)).thenReturn(Optional.of(account)); // Mock the repository to return the account
        accountRepository.save(account); // Save the account in the mocked repository
    }

    @Test
    public void should_Add_Deposit_ToAccount() {
        accountService.depot(1L, 100.0); 
        assertEquals(100.0, account.getSoldeDuCompte());
    }

    @Test
    public void should_WithdrawMoney_FromAccount() {
        accountService.depot(1L, 200.0);
        accountService.retrait(1L, 100.0); 
        assertEquals(100.0, account.getSoldeDuCompte());
    }

    @Test
    public void should_PrintAccount_Statement() {
        accountService.depot(1L, 200.0); 
        accountService.retrait(1L, 50.0);

        List<Historique> historiques = account.getHistoriques(); // Get the history
        assertEquals(2, historiques.size());
        assertEquals(200.0, historiques.get(0).getMontantDeLoperation());
        assertEquals(-50.0, historiques.get(1).getMontantDeLoperation());
    }

   
}