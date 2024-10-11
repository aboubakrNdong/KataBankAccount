package com.kata.bankaccount.adapter;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.kata.bankaccount.app.AccountService;
import com.kata.bankaccount.domain.model.Historique;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/depot")
    public ResponseEntity<String> depot(@RequestBody Map<String, Object> request) {
        try {
            long accountID = ((Number) request.get("accountID")).longValue(); 
            double montant = ((Number) request.get("montant")).doubleValue(); 
            accountService.depot(accountID, montant);
            return ResponseEntity.ok("Dépot réussi. Nouveau solde: " + accountService.getSoldeDuCompte(accountID));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/retrait")
    public ResponseEntity<String> retrait(@RequestBody Map<String, Object> request) {
        try {
            long accountID = ((Number) request.get("accountID")).longValue(); 
            double montant = ((Number) request.get("montant")).doubleValue(); 
            accountService.retrait(accountID, montant);
            return ResponseEntity.ok("Retrait réussi. Nouveau solde: " + accountService.getSoldeDuCompte(accountID));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/historique")
    public ResponseEntity<List<Historique>> getHistorique(@RequestParam long accountID) {
        return ResponseEntity.ok(accountService.getHistorique(accountID));
    }
}





