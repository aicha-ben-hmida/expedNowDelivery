package com.example.demo.ServiceMetier;

import org.springframework.stereotype.Service;

import com.example.demo.ModelDomain.DemandeLivraison;
import com.example.demo.ModelDomain.DemandeLivraisonStatus;
import com.example.demo.repository.DemandeLivraisonRepository;
import com.example.demo.repository.LivraisonRepository;
import com.example.demo.ModelDomain.User;
import com.example.demo.ModelDomain.UserRole;
import java.util.Set;

@Service
public class DemandeLivraisonSMImpl implements DemandeLivraisonServiceMetier{


    private DemandeLivraisonRepository demandeLivraisonRepository;
        private LivraisonRepository livraisonRepository;


   public DemandeLivraisonSMImpl(DemandeLivraisonRepository demandeLivraisonRepository, LivraisonRepository livraisonRepository){
    this.demandeLivraisonRepository = demandeLivraisonRepository;
    this.livraisonRepository = livraisonRepository;
   }

     public DemandeLivraison saveDemandeLivraison(DemandeLivraison demande){
      return demandeLivraisonRepository.save(demande);
     }
     
     public DemandeLivraison update(Long id, DemandeLivraison updatedDemande) {
    return demandeLivraisonRepository.findById(id)
        .map(existing -> {
            existing.setStatus(updatedDemande.getStatus());
            existing.setDatecreationdemande(updatedDemande.getDatecreationdemande());
            existing.setRequester(updatedDemande.getRequester());
            existing.setColis(updatedDemande.getColis());
            existing.setLivraison(updatedDemande.getLivraison());
            return demandeLivraisonRepository.save(existing);
        })
        .orElseThrow(() -> new RuntimeException("Demande de livraison non trouvée avec l'ID : " + id));
}

      public void verifierDemandeEnAttente(DemandeLivraison demandeLivraison, DemandeLivraisonStatus demandeLivraisonStatus,User user, UserRole userRole){
        if(demandeLivraison.getStatus() != demandeLivraisonStatus.En_ATTENTE){
          throw new IllegalStateException("la demande n est plus en attente");
        } 
        //status en attente
        DemandeLivraison demande = new DemandeLivraison();
        demande.setStatus(demandeLivraisonStatus.En_ATTENTE);
        }


      public void annulerParClient(DemandeLivraison demandeLivraison, DemandeLivraisonStatus demandeLivraisonStatus, User user, UserRole userRole) {
        if (demandeLivraison == null || user == null || userRole == null || demandeLivraisonStatus == null) {
          throw new IllegalArgumentExeption("des arguments sont null verifier");
        }

        if (Set.of(UserRole.CLIENT_ENTREPRISE, UserRole.CLIENT_PROFESSIONNEL).contains(userRole)) {
            if (Set.of(DemandeLivraisonStatus.EN_ATTENTE, DemandeLivraisonStatus.EN_COURS).contains(demandeLivraisonStatus)) {
                demandeLivraison.setStatus(DemandeLivraisonStatus.ANNULÉE);
            }
        }
    }
            
      public       
        
        
      }
 


    

      



