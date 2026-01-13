package com.petshoppb.pet.facade;

import com.petshoppb.pet.client.DogApiClient;
import com.petshoppb.pet.dto.PetRequestDTO;
import com.petshoppb.pet.dto.PetResponseDTO;
import com.petshoppb.pet.factory.PetInfoProviderFactory;
import com.petshoppb.pet.mapper.PetMapper;
import com.petshoppb.pet.model.Pet;
import com.petshoppb.pet.service.PetService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class PetFacade {

    private final PetService petService;
    private final PetInfoProviderFactory providerFactory;

    public PetFacade(PetService petService,
                     PetInfoProviderFactory providerFactory) {
        this.petService = petService;
        this.providerFactory = providerFactory;
    }

    public PetResponseDTO cadastrar(PetRequestDTO request) {

        Pet pet = PetMapper.toEntity(request);
        var provider = providerFactory.getProvider("DOG");
        provider.preencherInformacoes(pet);
        return PetMapper.toResponse(petService.salvar(pet));
    }

    public List<PetResponseDTO> listarTodos() {
        return petService.listarTodos()
                .stream()
                .map(PetMapper::toResponse)
                .collect(Collectors.toList());
    }

    public PetResponseDTO buscarPorId(UUID id) {
        return PetMapper.toResponse(petService.buscarPorId(id));
    }

    public PetResponseDTO atualizar(UUID id, PetRequestDTO request) {

        Pet pet = petService.buscarPorId(id);

        // atualiza dados básicos
        pet.setNomeDono(request.getNomeDono());
        pet.setTelefone(request.getTelefone());
        pet.setRaca(request.getRaca());

        // reaplica a strategy
        var provider = providerFactory.getProvider("DOG");
        provider.preencherInformacoes(pet);

        return PetMapper.toResponse(petService.atualizar(pet));
    }

    public void deletar(UUID id) {
        petService.deletar(id);
    }
}
