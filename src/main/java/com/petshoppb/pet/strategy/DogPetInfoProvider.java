package com.petshoppb.pet.strategy;

import com.petshoppb.pet.client.DogApiClient;
import com.petshoppb.pet.model.Pet;
import org.springframework.stereotype.Component;

@Component
public class DogPetInfoProvider implements PetInfoProvider {

    private final DogApiClient dogApiClient;

    public DogPetInfoProvider(DogApiClient dogApiClient) {
        this.dogApiClient = dogApiClient;
    }

    @Override
    public void preencherInformacoes(Pet pet) {

        var dogApi = dogApiClient.buscarPorRaca(pet.getRaca());

        if (dogApi != null) {
            pet.setPesoMedio(dogApi.getWeight().getMetric());
            pet.setComportamento(dogApi.getTemperament());
            pet.setTipoPelo("Não informado");
        }
    }
}
