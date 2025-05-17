package com.example.demo.Domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import com.example.poc.domain.Livreur;
import com.example.poc.domain.Admin;

@Entity
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

     private long id;

     @OneToMany(mappedBy= "vehicule" , cascade = CascadeType.ALL)
     private List<Livreur> livreur;
}
