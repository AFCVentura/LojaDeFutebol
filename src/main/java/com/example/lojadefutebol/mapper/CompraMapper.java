package com.example.lojadefutebol.mapper;

import com.example.lojadefutebol.Model.Compra;
import com.example.lojadefutebol.request.CompraRequest;
import com.example.lojadefutebol.response.CompraResponse;
import org.springframework.stereotype.Component;

@Component
public class CompraMapper {
    public Compra requestToEntity(CompraRequest request) {
        Compra entity = new Compra();
        entity.setId(request.getId());
        return entity;
    }

    public CompraResponse entityToResponse(Compra entity) {
        CompraResponse response = new CompraResponse();
        response.setId(entity.getId());

        return  response;
    }
}
