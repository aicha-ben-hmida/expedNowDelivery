package com.example.demo.ServiceMetier;

import com.example.demo.ModelDomain.DemandeLivraison;
import com.example.demo.ModelDomain.DemandeLivraisonStatus;
import com.example.demo.ModelDomain.User;
import com.example.demo.ModelDomain.UserRole;

public interface DemandeLivraisonServiceMetier {


    void verifierDemandeEnAttente(DemandeLivraison demandeLivraison,DemandeLivraisonStatus demandeLivraisonStatus);
    void annulerParClient(DemandeLivraison demandeLivraison, User user, UserRole userRole);
}
