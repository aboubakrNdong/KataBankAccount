package com.kata.bankaccount.app;

import org.springframework.stereotype.Service;
import com.kata.bankaccount.domain.model.Historique;
import java.util.List;


@Service
public interface AccountService {

        void depot(double montant);

        void retrait( double montant);

        List<Historique> getHistorique();

        double getSoldeDuCompte();
    }

    

