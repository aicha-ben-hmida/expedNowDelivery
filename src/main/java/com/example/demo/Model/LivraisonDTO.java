package com.example.demo.Model;


import com.example.demo.Domain.FragiliteColis;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LivraisonDTO {

     private long id;
     private String description;
     private String destinataire;
     private FragiliteColis fragiliteColis;


public LivraisonDTO(long id , String description, String destinataire, FragiliteColis fragiliteColis){
    this.id=id;
    this.description=description;
    this.destinataire=destinataire;
    this.fragiliteColis=fragiliteColis;
}


}