package com.petshoppb.pet.dto;

import java.util.UUID;

public class PetResponseDTO {

    private UUID id;

    private String nomeDono;
    private String telefone;

    private String raca;
    private String pesoMedio;
    private String tipoPelo;
    private String comportamento;

    public PetResponseDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getPesoMedio() {
        return pesoMedio;
    }

    public void setPesoMedio(String pesoMedio) {
        this.pesoMedio = pesoMedio;
    }

    public String getTipoPelo() {
        return tipoPelo;
    }

    public void setTipoPelo(String tipoPelo) {
        this.tipoPelo = tipoPelo;
    }

    public String getComportamento() {
        return comportamento;
    }

    public void setComportamento(String comportamento) {
        this.comportamento = comportamento;
    }
}