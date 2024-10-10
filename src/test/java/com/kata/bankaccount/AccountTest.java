package com.kata.bankaccount;

import org.junit.jupiter.api.Test;

import com.kata.bankaccount.domain.Account;
import com.kata.bankaccount.domain.Historique;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class AccountTest {
   
@Test
public void should_Add_Deposit_ToAccount() {
    Account account = new Account();
    account.depot(100.0);
    assertEquals(100.0, account.getsoldeDuCompte());
}

@Test
public void should_WithdrawMoney_FromAccount() {
    Account account = new Account();
    account.depot(200.0);
    account.retrait(100.0);
    assertEquals(100.0, account.getsoldeDuCompte());
}

@Test
public void should_PrintAccount_Statement() {
    Account account = new Account();
    account.depot(200.0);
    account.retrait(50.0);

    List<Historique> historiques = account.getHistorique();
    assertEquals(2, historiques.size());
    assertEquals(200.0, historiques.get(0).getMontantDepose());
    assertEquals(-50.0, historiques.get(1).getMontantDepose());
}

}