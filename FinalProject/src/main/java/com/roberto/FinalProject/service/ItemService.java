/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.service;

import com.roberto.FinalProject.dao.ItemRepository;
import com.roberto.FinalProject.model.Mods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author roberto
 */
@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;
    
    public void insertMod(){
        Mods mod=new Mods();
        mod.setName("Hola soy un mod");
        
       repository.save(mod);
    }
}
