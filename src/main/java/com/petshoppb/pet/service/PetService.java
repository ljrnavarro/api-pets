package com.petshoppb.pet.service;

import com.petshoppb.pet.model.Pet;
import com.petshoppb.pet.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet salvar(Pet pet) {
        return petRepository.save(pet);
    }

    public List<Pet> listarTodos() {
        return petRepository.findAll();
    }

    public Pet buscarPorId(UUID id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));
    }

    public Pet atualizar(Pet pet) {
        return petRepository.save(pet);
    }

    public void deletar(UUID id) {
        petRepository.deleteById(id);
    }
}
