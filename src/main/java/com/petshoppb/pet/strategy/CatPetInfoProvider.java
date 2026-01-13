package com.petshoppb.pet.strategy;

import com.petshoppb.pet.model.Pet;
import org.springframework.stereotype.Component;

@Component
public class CatPetInfoProvider implements PetInfoProvider {

    @Override
    public void preencherInformacoes(Pet pet) {
        // TODO: integrar API de gatos futuramente
    }
}
