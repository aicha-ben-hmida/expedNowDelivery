package com.example.demo.ServiceMetier;

import org.springframework.stereotype.Service;

import com.example.demo.ModelDomain.DemandeLivraison;
import com.example.demo.ModelDomain.DemandeLivraisonStatus;
import com.example.demo.ModelDomain.Livraison;
import com.example.demo.ModelDomain.LivraisonStatus;
import com.example.demo.repository.DemandeLivraisonRepository;
import com.example.demo.repository.LivraisonRepository;
import com.example.demo.ModelDomain.User;
import com.example.demo.ModelDomain.UserRole;

import java.util.Date;
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
        if(!demandeLivraison.getStatus().equals(demandeLivraisonStatus.En_ATTENTE)){
          throw new IllegalStateException("la demande n est plus en attente");
        } 
       


      public void annulerDemandeParClient(DemandeLivraison demandeLivraison, User user, UserRole userRole) {
             
          if (demandeLivraison == null || user == null || userRole == null ) {
                throw new IllegalArgumentException("des arguments sont null verifier");
              }

              if (Set.of(UserRole.CLIENT_ENTREPRiSE, UserRole.CLIENT_PROFESSIONNEL).contains(userRole)) {
                  if (Set.of(DemandeLivraisonStatus.En_ATTENTE, DemandeLivraisonStatus.EN_COURS).contains(demandeLivraison.getStatus())) {
                      demandeLivraison.setStatus(DemandeLivraisonStatus.ANNULER);
                  }
              }

              if (!Set.of(UserRole.CLIENT_ENTREPRiSE, UserRole.CLIENT_PROFESSIONNEL).contains(userRole.)) {
                  throw new RuntimeException("role");
              }

              if (!Set.of(DemandeLivraisonStatus.En_ATTENTE, DemandeLivraisonStatus.EN_COURS).contains(demandeLivraison.getStatus())) {
                     throw new RuntimeException("status");
                  }

                  demandeLivraison.setStatus(DemandeLivraisonStatus.ANNULER);

            }      
      

         public void AcceptationParlivreur(User user,UserRole userRole, DemandeLivraison demandeLivraison){
                   
                   if (userRole == UserRole.LIVREUR_PERMANENT || userRole == UserRole.LIVREUR_OCCASIONNEL){
                        user.setRole(userRole);
                        demandeLivraison.setRequester(user);
                   }else {
                    throw new IllegalArgumentException("Rôle non autorisé pour accepter une demande.");
                   }
                   verifierDemandeEnAttente(demandeLivraison, DemandeLivraisonStatus.En_ATTENTE,  user, userRole);
                   demandeLivraison.setStatus(DemandeLivraisonStatus.EN_COURS);

                   
             
           }
      
      public void creationLivraison(DemandeLivraison demandeLivraison, User user, UserRole userRole){

                   AcceptationParlivreur(user, userRole, demandeLivraison);  
                   Livraison livraison = new Livraison(LivraisonStatus.CREER, new Date()) ;
                   demandeLivraison.setStatus(DemandeLivraisonStatus.EN_COURS);      
      }


     

      public void annulerLivraisonParClient(Livraison livraison,User user, UserRole userRole, DemandeLivraison demandeLivraison){
          
        if(livraison == null || user ==  null || userRole == null)  {
            throw new IllegalArgumentException("des arguments sont verifiers null");
        }
            if (!Set.of(UserRole.CLIENT_ENTREPRiSE, UserRole.CLIENT_PROFESSIONNEL).contains(user.getRole())) {
                  if (!Set.of(LivraisonStatus.CREER, LivraisonStatus.EN_COURS).contains(livraison.getStatut())) {
                     livraison.setStatut(LivraisonStatus.ANNULER);
                     demandeLivraison.setStatus(DemandeLivraisonStatus.ANNULER);
                    }
                    } else {
                throw new IllegalStateException("La demande ne peut pas être annulée à ce stade.");
        }

               }}

     
              
              

               
              
              
      
    


    

      



