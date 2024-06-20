package com.example.lojadefutebol.Controller;

import com.example.lojadefutebol.Model.Cliente;
import com.example.lojadefutebol.Model.Item;
import com.example.lojadefutebol.Repository.ClienteRepository;
import com.example.lojadefutebol.Repository.ClubeRepository;
import com.example.lojadefutebol.Repository.ItemRepository;
import com.example.lojadefutebol.mapper.ClienteMapper;
import com.example.lojadefutebol.request.ByIdRequest;
import com.example.lojadefutebol.request.ClienteRequest;
import com.example.lojadefutebol.response.ClienteResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Cliente")
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    ClubeRepository clubeRepository;

    @GetMapping
    public List<Cliente> getAllCliente() {
        return clienteRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> createCliente(@RequestBody ClienteRequest request) {

        Cliente cliente = clienteMapper.requestToEntity(request);
        cliente.setClube(clubeRepository.findById(request.getClube().longValue()).get());
        clienteRepository.save(cliente);
        ClienteResponse response = clienteMapper.entityToResponse(cliente);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping
        public ResponseEntity<Void> deleteCliente(@RequestBody ByIdRequest request) {
        try {
            clienteRepository.deleteById(request.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

