package com.example.demo.ModelDTO;
import com.example.demo.ModelDTO.DemandelivraisonDTO;
import com.example.demo.ModelDTO.LivraisonDTO;

public class DemandeLivraisonAvecLivraisonDTO {

    private DemandelivraisonDTO demandelivraisonDTO;
    private LivraisonDTO livraisonDTO;

    public DemandeLivraisonAvecLivraisonDTO(DemandelivraisonDTO demandelivraisonDTO,LivraisonDTO livraisonDTO){
        this.demandelivraisonDTO = demandelivraisonDTO;
        this.livraisonDTO = livraisonDTO;
    }

}
