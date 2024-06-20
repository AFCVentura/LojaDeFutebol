package com.example.lojadefutebol.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.lojadefutebol.Model.Usuarios;


public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    UserDetails findByLogin(String login);
}
