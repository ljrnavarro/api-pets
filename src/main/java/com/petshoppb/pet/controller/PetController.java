package com.petshoppb.pet.controller;

import com.petshoppb.pet.dto.PetRequestDTO;
import com.petshoppb.pet.dto.PetResponseDTO;
import com.petshoppb.pet.facade.PetFacade;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetFacade petFacade;

    public PetController(PetFacade petFacade) {
        this.petFacade = petFacade;
    }

    @PostMapping
    public ResponseEntity<PetResponseDTO> cadastrar(@RequestBody @Valid PetRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(petFacade.cadastrar(request));
    }

    @GetMapping
    public ResponseEntity<List<PetResponseDTO>> listarTodos() {
        return ResponseEntity.ok(petFacade.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetResponseDTO> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(petFacade.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetResponseDTO> atualizar(
            @PathVariable UUID id,
            @RequestBody @Valid PetRequestDTO request) {

        return ResponseEntity.ok(petFacade.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable UUID id) {
        petFacade.deletar(id);
    }
}
