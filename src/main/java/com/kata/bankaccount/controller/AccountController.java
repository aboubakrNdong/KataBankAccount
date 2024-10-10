package com.kata.bankaccount.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.kata.bankaccount.model.Account;
import com.kata.bankaccount.model.Historique;
import com.kata.bankaccount.service.AccountService;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final Account account = new Account();

    @Autowired
    private AccountService accountService;

    @PostMapping("/depot")
    public ResponseEntity<String> depot(@RequestBody Map<String, Double> request) {
        try {

       double amount = request.get("amount");
       accountService.depot(amount);
       return ResponseEntity.ok("Deposit successful. New balance: " + account.getBalance());
       
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/retrait")
    public ResponseEntity<String> retrait(@RequestBody Map<String, Double> request) {
        try {
            double amount = request.get("amount");
            accountService.retrait(amount);
            return ResponseEntity.ok("Withdrawal successful. New balance: " + account.getBalance());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/historique")
    public ResponseEntity<List<Historique>> getHistorique() {
        return ResponseEntity.ok(account.getHistorique());
    }
}

