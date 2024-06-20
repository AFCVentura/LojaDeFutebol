package com.example.lojadefutebol.Controller;

import com.example.lojadefutebol.Model.Cliente;
import com.example.lojadefutebol.Model.Clube;
import com.example.lojadefutebol.Repository.ClubeRepository;
import com.example.lojadefutebol.mapper.ClubeMapper;
import com.example.lojadefutebol.request.ByIdRequest;
import com.example.lojadefutebol.request.ClubeRequest;
import com.example.lojadefutebol.response.ClienteResponse;
import com.example.lojadefutebol.response.ClubeResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Clube")
@RequestMapping("/clube")
public class ClubeController {

    @Autowired
    private ClubeRepository clubeRepository;

    @Autowired
    private ClubeMapper mapper;

    @GetMapping
    public List<Clube> getAllClube() {
        return clubeRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<ClubeResponse> createClube(@RequestBody ClubeRequest request) {
        Clube clube = mapper.requestToEntity(request);
        clubeRepository.save(clube);
        ClubeResponse response = mapper.entityToResponse(clube);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/findbyid")
    public ResponseEntity<ClubeResponse> getById(@RequestBody ByIdRequest request) {

        Optional<Clube> clube = clubeRepository.findById(request.getId());
        if(clube.isPresent()){
            return new ResponseEntity<>(mapper.entityToResponse(clube.get()),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteClube(@RequestBody ByIdRequest request) {
        try{clubeRepository.deleteById(request.getId());
        return new ResponseEntity<>(HttpStatus.OK);}
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
