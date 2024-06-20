package com.example.lojadefutebol.mapper;

import com.example.lojadefutebol.Model.Item;
import com.example.lojadefutebol.request.ItemRequest;
import com.example.lojadefutebol.response.ItemResponse;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    public Item requestToEntity(ItemRequest item) {
        Item entity = new Item();
        entity.setCor(item.getCor());
        entity.setId(item.getId());
        entity.setMarca(item.getMarca());
        entity.setTamanho(item.getTamanho());

        return entity;
    }

    public ItemResponse entityToResponse(Item item) {

        ItemResponse response = new ItemResponse();

        response.setCor(item.getCor());
        response.setId(item.getId());
        response.setMarca(item.getMarca());
        response.setTamanho(item.getTamanho());

        return response;
    }
}
