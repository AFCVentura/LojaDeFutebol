package com.example.lojadefutebol.Repository;

import com.example.lojadefutebol.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}