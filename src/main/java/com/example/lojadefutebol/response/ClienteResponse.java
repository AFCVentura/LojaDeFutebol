package com.example.lojadefutebol.response;


import java.util.Set;

public class ClienteResponse {

    private Long id;
    private String nome;
    private String endereco;
    private String cpf;
    private Set<CompraResponse> compras;
    private ClubeResponse clube;

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Set<CompraResponse> getCompras() {
        return compras;
    }

    public void setCompras(Set<CompraResponse> compras) {
        this.compras = compras;
    }

    }
