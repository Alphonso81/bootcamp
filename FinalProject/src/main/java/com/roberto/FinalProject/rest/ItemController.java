/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.rest;

import com.roberto.FinalProject.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author roberto
 */
@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;
    
    @GetMapping("/insertMod")
    public ResponseEntity insert(){
        itemService.insertMod();
        return new ResponseEntity("Hola", HttpStatus.CREATED);
    }
}
