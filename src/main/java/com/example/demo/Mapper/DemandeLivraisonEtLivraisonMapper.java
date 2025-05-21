package com.example.demo.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.demo.ModelDTO.DemandeLivraisonAvecLivraisonDTO;
import com.example.demo.ModelDomain.DemandeLivraison;
import com.example.demo.ModelDomain.Livraison;
@Mapper(componentModel = "spring")

public interface DemandeLivraisonEtLivraisonMapper {

        DemandeLivraisonEtLivraisonMapper INSTANCE = Mappers.getMapper(DemandeLivraisonEtLivraisonMapper.class);

        DemandeLivraisonAvecLivraisonDTO toDto(DemandeLivraison demandeLivraison , Livraison livraison);

}
