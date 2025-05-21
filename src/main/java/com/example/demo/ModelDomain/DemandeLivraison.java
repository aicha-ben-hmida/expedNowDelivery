package com.example.demo.ModelDomain;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.ModelDomain.DemandeLivraisonStatus;
import com.example.demo.ModelDomain.Livraison;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.demo.ModelDomain.DemandeLivraisonStatus;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class DemandeLivraison {
    @Id
    @GeneratedValue
    private Long id;

    private DemandeLivraisonStatus status;

    private LocalDate datecreationdemande;

    public DemandeLivraison(LocalDate datecreationdemande, DemandeLivraisonStatus status){
        this.datecreationdemande = datecreationdemande;
        this.status = status;
    }
    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private User requester;

       
    @OneToMany(mappedBy = "colis")
    private List<Colis> colis;

       
    @OneToMany(mappedBy = "livraison")
    private List<Livraison> livraison;

}
