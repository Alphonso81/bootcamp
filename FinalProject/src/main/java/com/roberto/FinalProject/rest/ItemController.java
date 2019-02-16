/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.rest;

import com.roberto.FinalProject.errorHandler.EntityNotFoundException;
import com.roberto.FinalProject.model.Game;
import com.roberto.FinalProject.model.Item;
import com.roberto.FinalProject.model.Mods;

import com.roberto.FinalProject.service.ItemService;
import com.roberto.FinalProject.service.ModService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author roberto
 */
@RestController
@RequestMapping("/Item")
public class ItemController {
    @Autowired
    private ItemService itemService;
    
       
   @GetMapping("/Items")
   public ResponseEntity getAllItems(){
      
    List<Item> list=itemService.getAllItems();
       return new ResponseEntity(list, HttpStatus.CREATED);
   }
   
  
      
  
 
}//endController
