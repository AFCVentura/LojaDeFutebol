package com.example.lojadefutebol.mapper;

import com.example.lojadefutebol.Model.Cliente;
import com.example.lojadefutebol.request.ClienteRequest;
import com.example.lojadefutebol.response.ClienteResponse;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
    public Cliente requestToEntity(ClienteRequest request) {
        Cliente entity = new Cliente();
        entity.setId(request.getId());
        entity.setCpf(request.getCpf());
        entity.setNome(request.getNome());
        entity.setEndereco(request.getEndereco());

        return entity;
    }

    public ClienteResponse entityToResponse(Cliente cliente) {
        ClienteResponse response = new ClienteResponse();
        response.setId(cliente.getId());
        response.setNome(cliente.getNome());
        response.setEndereco(cliente.getEndereco());
        response.setCpf(cliente.getCpf());
        return response;
    }
}
