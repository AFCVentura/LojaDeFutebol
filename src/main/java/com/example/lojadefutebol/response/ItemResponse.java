package com.example.lojadefutebol.response;

import java.util.Set;

public class ItemResponse {

    private Long id;
    private String cor;
    private Float tamanho;
    private String marca;
    private Set<CompraResponse> compras;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Float getTamanho() {
        return tamanho;
    }

    public void setTamanho(Float tamanho) {
        this.tamanho = tamanho;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Set<CompraResponse> getCompras() {
        return compras;
    }

    public void setCompras(Set<CompraResponse> compras) {
        this.compras = compras;
    }
}
