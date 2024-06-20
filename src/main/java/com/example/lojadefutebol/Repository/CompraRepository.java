package com.example.lojadefutebol.Repository;

import com.example.lojadefutebol.Model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CompraRepository extends JpaRepository<Compra, Long> {

}
