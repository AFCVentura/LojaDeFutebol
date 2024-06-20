package com.example.lojadefutebol.Repository;

import com.example.lojadefutebol.Model.Clube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




public interface ClubeRepository extends JpaRepository<Clube, Long> {
}
