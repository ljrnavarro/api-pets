package com.petshoppb.pet.factory;

import com.petshoppb.pet.strategy.CatPetInfoProvider;
import com.petshoppb.pet.strategy.DogPetInfoProvider;
import com.petshoppb.pet.strategy.PetInfoProvider;
import org.springframework.stereotype.Component;

@Component
public class PetInfoProviderFactory {

    private final DogPetInfoProvider dogProvider;
    private final CatPetInfoProvider catProvider;

    public PetInfoProviderFactory(
            DogPetInfoProvider dogProvider,
            CatPetInfoProvider catProvider) {
        this.dogProvider = dogProvider;
        this.catProvider = catProvider;
    }

    public PetInfoProvider getProvider(String tipo) {

        if ("CAT".equalsIgnoreCase(tipo)) {
            return catProvider;
        }

        // padrão
        return dogProvider;
    }
}
