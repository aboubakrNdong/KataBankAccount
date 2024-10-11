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
    public ResponseEntity<String> depot(@RequestBody Map<String, Double> request) {
        try {

            double montant = request.get("montant");
            accountService.depot(montant);
       return ResponseEntity.ok("dépot réussi. nouveau solde: " + accountService.getSoldeDuCompte());
       
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/retrait")
    public ResponseEntity<String> retrait(@RequestBody Map<String, Double> request) {
        try {
            double montant = request.get("montant");
            accountService.retrait(montant);
            return ResponseEntity.ok("Retrait réussi. Nouveau solde: " + accountService.getSoldeDuCompte());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/historique")
    public ResponseEntity<List<Historique>> getHistorique() {
        return ResponseEntity.ok(accountService.getHistorique());
    }
}





