/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.rest;

import com.roberto.FinalProject.errorHandler.EntityNotFoundException;
import com.roberto.FinalProject.model.Game;
import com.roberto.FinalProject.model.Mods;
import com.roberto.FinalProject.service.GameService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author roberto
 */
@RestController
public class GameController {

    @Autowired
    private GameService gameService;
    
    @PostMapping("/Games")
    public ResponseEntity saveGame(@RequestBody Game game){
        Game newGame=gameService.saveGame(game);
        return new ResponseEntity(newGame, HttpStatus.CREATED);
    }
    
    @GetMapping("/Games")
    public ResponseEntity getAllGames(){
           List<Game> list = gameService.getAllGames();
            return new ResponseEntity(list, HttpStatus.FOUND);            
    }
    
    @GetMapping("/Games/Name/{nameGame}")
    public ResponseEntity getGameByName(@PathVariable("nameGame")String name) throws EntityNotFoundException{
        Game game=gameService.findGameByName(name);
        return new ResponseEntity(game, HttpStatus.FOUND);
    }
    
    @GetMapping("/Games/Id/{idGame}")
    public ResponseEntity getGameByName(@PathVariable("idGame")Long idGame) throws EntityNotFoundException{
        Game game=gameService.findGameById(idGame);
        return new ResponseEntity(game, HttpStatus.FOUND);
    }
    
    @PutMapping("/Games")
    public ResponseEntity updateGame(@RequestBody Game game) throws EntityNotFoundException{
        Game newUpdateGame=gameService.updateGame(game);
        return new ResponseEntity(game, HttpStatus.OK);
    }
    
     @GetMapping("/Games/ModsGame/Id/{idGame}")
    public ResponseEntity getModsGameById(@PathVariable("idGame")Long idGame) throws EntityNotFoundException{
        List<Mods> list=gameService.getModsGameById(idGame);
        return new ResponseEntity(list, HttpStatus.FOUND);
    }
     @GetMapping("/Games/ModsGame/Name/{nameGame}")
    public ResponseEntity getModsGameByName(@PathVariable("nameGame")String name) throws EntityNotFoundException{
        List<Mods> list=gameService.getModsGameByName(name);
        return new ResponseEntity(list, HttpStatus.FOUND);
    }
  
}//endController
