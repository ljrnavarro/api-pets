package com.petshoppb.pet.mapper;

import com.petshoppb.pet.dto.PetRequestDTO;
import com.petshoppb.pet.dto.PetResponseDTO;
import com.petshoppb.pet.model.Pet;

import java.util.UUID;

public class PetMapper {

    private PetMapper() {
        // evita instanciação
    }

    public static Pet toEntity(PetRequestDTO dto) {

        Pet pet = new Pet();
        pet.setId(UUID.randomUUID());

        // dados do dono
        pet.setNomeDono(dto.getNomeDono());
        pet.setTelefone(dto.getTelefone());

        // dados do pet
        pet.setRaca(dto.getRaca());

        // dados que virão da API externa depois
        pet.setPesoMedio(null);
        pet.setTipoPelo(null);
        pet.setComportamento(null);

        return pet;
    }

    public static PetResponseDTO toResponse(Pet pet) {

        PetResponseDTO dto = new PetResponseDTO();

        dto.setId(pet.getId());
        dto.setNomeDono(pet.getNomeDono());
        dto.setTelefone(pet.getTelefone());

        dto.setRaca(pet.getRaca());
        dto.setPesoMedio(pet.getPesoMedio());
        dto.setTipoPelo(pet.getTipoPelo());
        dto.setComportamento(pet.getComportamento());

        return dto;
    }
}