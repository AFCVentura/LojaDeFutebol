package com.example.lojadefutebol.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lojadefutebol.Model.Usuarios;
import com.example.lojadefutebol.Repository.UsuariosRepository;
import com.example.lojadefutebol.request.AuthenticationRequest;
import com.example.lojadefutebol.request.RegisterRequest;
import com.example.lojadefutebol.services.TokenService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name = "Usuarios")
@RequestMapping("/auth")
public class UsuariosController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UsuariosRepository repository;

    @Autowired
    private TokenService tokenService;
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid AuthenticationRequest data){
        var usernamePassWord = new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword());
        var auth = authManager.authenticate(usernamePassWord);

        var token = tokenService.generateToken( (Usuarios) auth.getPrincipal());
        return new ResponseEntity<>(token,HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequest data){
        if(repository.findByLogin(data.getLogin()) != null) return ResponseEntity.badRequest().build();
        
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
        Usuarios newUser = new Usuarios();
        newUser.setLogin(data.getLogin());
        newUser.setSenha(encryptedPassword);
        newUser.setRole(data.getRole());

        repository.save(newUser);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
