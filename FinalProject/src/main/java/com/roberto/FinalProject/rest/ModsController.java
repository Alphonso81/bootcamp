/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.rest;

import com.roberto.FinalProject.errorHandler.EntityNotFoundException;
import com.roberto.FinalProject.model.Mods;
import com.roberto.FinalProject.model.dot.dotModToGame;
import com.roberto.FinalProject.service.ModService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author roberto
 */
@RestController
public class ModsController {

    @Autowired
    private ModService modService;

    @PostMapping("/Mods")
    public ResponseEntity saveGame(@RequestBody Mods mod) {
        Mods newMod = modService.saveMod(mod);
        return new ResponseEntity(newMod, HttpStatus.CREATED);
    }

    @GetMapping("/Mods")
    public ResponseEntity getAllMods() {
        Iterable<Mods> list = modService.getAllMods();
        return new ResponseEntity(list, HttpStatus.CREATED);
    }

    @GetMapping("/Mods/Id/{idMod}")
    public ResponseEntity getModById(@PathVariable("idMod") Long idMod) throws EntityNotFoundException {
        Mods mod = modService.getModById(idMod);
        return new ResponseEntity(mod, HttpStatus.FOUND);
    }

    @GetMapping("/Mods/Name/{nameMod}")
    public ResponseEntity getGameByName(@PathVariable("nameGame") String name) throws EntityNotFoundException {
        Mods mod = modService.findModByName(name);
        return new ResponseEntity(mod, HttpStatus.FOUND);
    }

    @PutMapping("/Mods")
    public ResponseEntity updateMod(@RequestBody Mods mod) throws EntityNotFoundException {
        Mods newUpdateGame = modService.updateMod(mod);
        return new ResponseEntity(newUpdateGame, HttpStatus.OK);
    }
    
    @PutMapping("/ModToGame")
    public ResponseEntity updateModToGame(@RequestBody dotModToGame dotMG) throws EntityNotFoundException{
        Mods mod=modService.updateModToGame(dotMG);
        return new ResponseEntity(mod, HttpStatus.ACCEPTED);
    }
}//endController
