package com.kata.bankaccount;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.kata.bankaccount.Adapter.AccountController;
import com.kata.bankaccount.app.AccountService;
import com.kata.bankaccount.domain.Account;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

 
@WebMvcTest(AccountController.class)
public class AccountControllerTest {
/* 
    @Autowired
    private MockMvc mockMvc;

    
    @MockBean
    private AccountService accountService;


    @Test
    public void testDeposit() throws Exception {
        doNothing().when(accountService).depot(100.0);
        mockMvc.perform(post("/api/account/depot").param("amount", "100"))
                .andExpect(status().isOk())
                .andExpect(content().string("Deposit successful. New balance: 100.0"));
    }

    @Test
    public void testWithdraw() throws Exception {
        doNothing().when(accountService).depot(100.0);
        doNothing().when(accountService).retrait(50.0);
        mockMvc.perform(post("/api/account/depot").param("amount", "100"));
        mockMvc.perform(post("/api/account/retrait").param("amount", "50"))
                .andExpect(status().isOk())
                .andExpect(content().string("Withdrawal successful. New balance: 50.0"));
    }

    @Test
    public void testGetStatement() throws Exception {
        mockMvc.perform(get("/api/account/historique"))
                .andExpect(status().isOk());
    }*/
}







/*@Test
public void shouldAddDepositToAccount() {
    Account account = new Account();
    account.deposit(100.0);
    assertEquals(100.0, account.getBalance());
}

@Test
public void shouldWithdrawMoneyFromAccount() {
    Account account = new Account();
    account.deposit(200.0);
    account.withdraw(100.0);
    assertEquals(100.0, account.getBalance());
}

@Test
public void shouldPrintAccountStatement() {
    Account account = new Account();
    account.deposit(200.0);
    account.withdraw(50.0);

    List<Transaction> transactions = account.getStatement();
    assertEquals(2, transactions.size());
    assertEquals(200.0, transactions.get(0).getAmount());
    assertEquals(-50.0, transactions.get(1).getAmount());
}
*/