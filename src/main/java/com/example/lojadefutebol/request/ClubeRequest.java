package com.example.lojadefutebol.request;

import com.example.lojadefutebol.Model.Cliente;
import com.example.lojadefutebol.response.ClienteResponse;

import java.util.Set;

public class ClubeRequest {
    private Long id;
    private String nome;
    private String pais;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
