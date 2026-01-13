package com.petshoppb.pet.repository;

import com.petshoppb.pet.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PetRepository extends JpaRepository<Pet, UUID> {
}
