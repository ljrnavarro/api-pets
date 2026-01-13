package com.petshoppb.pet.dto;

import jakarta.validation.constraints.NotBlank;

public class PetRequestDTO {

    @NotBlank(message = "Nome do dono é obrigatório")
    private String nomeDono;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    @NotBlank(message = "Raça é obrigatória")
    private String raca;

    public PetRequestDTO() {
    }

    public String getNomeDono() {
        return nomeDono;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
}
