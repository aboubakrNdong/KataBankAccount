package com.kata.bankaccount.app;

import org.springframework.stereotype.Service;
import com.kata.bankaccount.domain.model.Historique;
import java.util.List;

@Service
public interface AccountService {

        void depot(long accountID, double montant);

        void retrait(long accountID, double montant);

        List<Historique> getHistorique(long accountID);

        double getSoldeDuCompte(long accountID);
    }

    

