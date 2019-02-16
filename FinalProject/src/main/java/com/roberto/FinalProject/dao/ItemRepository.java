/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.dao;

import com.roberto.FinalProject.model.Item;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author roberto
 */
@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{
    
    @Query(nativeQuery = true,
            value = "SELECT * FROM item")
    List<Item> findByType(String type);
    
   // List<Item> findMods();
    
}
