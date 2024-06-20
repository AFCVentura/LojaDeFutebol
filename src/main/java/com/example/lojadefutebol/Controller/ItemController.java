package com.example.lojadefutebol.Controller;

import com.example.lojadefutebol.Model.Clube;
import com.example.lojadefutebol.Model.Item;
import com.example.lojadefutebol.Repository.ItemRepository;
import com.example.lojadefutebol.mapper.ItemMapper;
import com.example.lojadefutebol.request.ByIdRequest;
import com.example.lojadefutebol.request.ItemRequest;
import com.example.lojadefutebol.response.ClubeResponse;
import com.example.lojadefutebol.response.ItemResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@Tag(name = "Item")
@RequestMapping(value = "/item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    ItemMapper mapper;


    @GetMapping
    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<ItemResponse> createItem(@RequestBody ItemRequest item)
    {
        Item entity = mapper.requestToEntity(item);
        itemRepository.save(entity);
        ItemResponse response = mapper.entityToResponse(entity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/findById")
    public ResponseEntity<Item> getItemById(@RequestBody ByIdRequest request) {
        try {
            return new ResponseEntity<>(itemRepository.findById(request.getId()).get(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteItem(@RequestBody ByIdRequest request) {
        return itemRepository.findById(request.getId())
                .map(item -> {
                    itemRepository.delete(item);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}




