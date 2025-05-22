package com.example.demo.ServiceMetier;

import com.example.demo.ModelDomain.DemandeLivraison;
import com.example.demo.ModelDomain.DemandeLivraisonStatus;
import com.example.demo.ModelDomain.Livraison;
import com.example.demo.ModelDomain.LivraisonStatus;
import com.example.demo.ModelDomain.User;
import com.example.demo.ModelDomain.UserRole;

public interface DemandeLivraisonServiceMetier {


    void verifierDemandeEnAttente(DemandeLivraison demandeLivraison,DemandeLivraisonStatus demandeLivraisonStatus, User user,UserRole userRole);
    void annulerDemandeParClient(DemandeLivraison demandeLivraison, User user, UserRole userRole);
    void creationLivraison(DemandeLivraison demandeLivraison, User user, UserRole userRole);
    void annulerLivraisonParClient(Livraison livraison,LivraisonStatus livraisonStatus,User user); 
    void AcceptationParlivreur(User user,UserRole userRole, DemandeLivraison demandeLivraison, DemandeLivraisonStatus demandeLivraisonStatus, Livraison livraison, LivraisonStatus livraisonStatus);
     void annulerLivraisonParClient(Livraison livraison,User user, UserRole userRole, DemandeLivraison demandeLivraison);
}
