package com.example.lojadefutebol.Repository;

import com.example.lojadefutebol.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
