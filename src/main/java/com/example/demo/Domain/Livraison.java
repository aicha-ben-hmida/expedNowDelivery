package com.example.demo.Domain;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import com.example.demo.Domain.DemandeLivraison;
import com.example.demo.Domain.LivraisonStatus;


@Entity
@Getter
@Setter

public class Livraison {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;

       private LivraisonStatus statut;

       private LocalDate dateLivraison;


       public Livraison(LivraisonStatus statut, LocalDate dateLivraison) 
       {
              this.statut= statut;
              this.dateLivraison = dateLivraison;
       }

@ManyToOne
@JoinColumn(name = "livraison")
private DemandeLivraison demandeLivraison;




}