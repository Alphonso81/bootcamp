/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.rest;

import com.roberto.FinalProject.model.Mods;
import com.roberto.FinalProject.service.ModService;
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
@RequestMapping("/Mod")
public class ModsController {
    
    @Autowired
    private ModService modService;
    
     @GetMapping("/Mods")
   public ResponseEntity getAllMods(){
       Iterable<Mods> list=modService.getAllMods();
       return new ResponseEntity(list, HttpStatus.CREATED);
   }
   
}//endController
