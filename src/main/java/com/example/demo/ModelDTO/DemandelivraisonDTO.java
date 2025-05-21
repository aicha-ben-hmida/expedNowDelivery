package com.example.demo.ModelDTO;

import java.time.LocalDate;
import java.util.List;
import com.example.demo.ModelDTO.ColisDTO;
import com.example.demo.ModelDTO.UserDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import com.example.demo.ModelDTO.LivraisonDTO;

@Data
@Getter
@Setter
public class DemandelivraisonDTO {

     private Long id;
    private LocalDate datecreationdemande;
    private UserDTO requester; // détails du user
    private List<ColisDTO> colis; // détails des colis
    private List<LivraisonDTO> livraison;

    public DemandelivraisonDTO(Long id, LocalDate datecreationdemande, UserDTO requester,
                               List<ColisDTO> colis, List<LivraisonDTO> livraison) {
        this.id = id;
        this.datecreationdemande = datecreationdemande;
        this.requester = requester;
        this.colis = colis;
        this.livraison = livraison;
    }}


