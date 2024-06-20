package com.example.lojadefutebol.Controller;
import java.util.List;

import com.example.lojadefutebol.Model.Item;
import com.example.lojadefutebol.Repository.ClienteRepository;
import com.example.lojadefutebol.Repository.CompraRepository;

import com.example.lojadefutebol.Repository.ItemRepository;
import com.example.lojadefutebol.mapper.CompraMapper;
import com.example.lojadefutebol.request.ByIdRequest;
import com.example.lojadefutebol.request.CompraRequest;
import com.example.lojadefutebol.response.CompraResponse;
import com.example.lojadefutebol.response.ItemResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.lojadefutebol.Model.Compra;

@RestController
@RequestMapping(value = "/compra", method = RequestMethod.OPTIONS)
@Tag(name = "Compras")
public class CompraController {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    private CompraMapper mapper;

    @GetMapping
    public List<Compra> getAllCompras() {
        return compraRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<CompraResponse> createCompra(@RequestBody CompraRequest request) {
        Compra entity = mapper.requestToEntity(request);
       try {
           entity.setCliente(clienteRepository.findById(request.getCliente().longValue()).get());
           entity.setItem(itemRepository.findById(request.getItem().longValue()).get());
           compraRepository.save(entity);
        CompraResponse response = mapper.entityToResponse(entity);
        return new ResponseEntity<>(HttpStatus.CREATED);
       }catch (Exception e){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCompra(@RequestBody ByIdRequest request) {
        return compraRepository.findById(request.getId())
                .map(compra -> {
                    compraRepository.delete(compra);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }





}
