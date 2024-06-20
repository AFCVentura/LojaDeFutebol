package com.example.lojadefutebol.mapper;

import com.example.lojadefutebol.Model.Clube;
import com.example.lojadefutebol.request.ClubeRequest;
import com.example.lojadefutebol.response.ClienteResponse;
import com.example.lojadefutebol.response.ClubeResponse;
import org.springframework.stereotype.Component;

@Component
public class ClubeMapper {
    public Clube requestToEntity(ClubeRequest request) {
        Clube entity = new Clube();
        entity.setId(request.getId());
        entity.setNome(request.getNome());
        entity.setPais(request.getPais());

        return entity;
    }

    public ClubeResponse entityToResponse(Clube clube) {
        ClubeResponse response = new ClubeResponse();

        response.setId(clube.getId());
        response.setNome(clube.getNome());
        response.setPais(clube.getPais());

        return response;
    }
}
