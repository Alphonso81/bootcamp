/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.service;

import com.roberto.FinalProject.dao.GameRepository;
import com.roberto.FinalProject.dao.ModRepository;
import com.roberto.FinalProject.errorHandler.EntityNotFoundException;
import com.roberto.FinalProject.model.Game;
import com.roberto.FinalProject.model.Mods;
import java.time.OffsetDateTime;
import java.util.ArrayList;

import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 *
 * @author roberto
 */
@Service
public class GameService {
    @Autowired
    private GameRepository gameRepo;
    
    @Autowired
    private ModRepository modRepo;
    
     private static final Logger logger = LogManager.getLogger(GameService.class);
    
    public List<Game> getAllGames() {
        List<Game> lst=gameRepo.findAll();
        List<Game> result=new ArrayList<>();
        
        for(Game g:lst)
            if(g.getDeletionDate()==null)
                result.add(g);
        
        
       return result;
    }
    
    public Game findGameByName(String name) throws EntityNotFoundException{
        Game filter=new Game();
        filter.setName(name);
        
        Example example=Example.of(filter);
        
        Game result=(Game)gameRepo.findOne(example).orElse(null);
        
        if(result==null || result.getDeletionDate()==null)
            throw new EntityNotFoundException(Game.class,"name",name);
        
        return result;
    }

    public Game saveGame(Game game) {
        game.setCreationDate(OffsetDateTime.now());
        return gameRepo.save(game);
    }

    public Game findGameById(Long idGame) throws EntityNotFoundException {
      
        Game result=gameRepo.findById(idGame).orElse(null);
        
        if(result==null|| result.getDeletionDate()==null)
            throw new EntityNotFoundException(Game.class,"id",idGame.toString());
        
        return result;
    }

    public Game updateGame(Game game) throws EntityNotFoundException {
        Game g=gameRepo.findById(game.getId()).orElse(null);
        if(g==null|| g.getDeletionDate()==null)
            throw new EntityNotFoundException(Game.class,"id",game.getId().toString());
        game.setEditionDate(OffsetDateTime.now());
        gameRepo.save(game);
        return game;
    }

    public List<Mods> getModsGameById(Long idGame) throws EntityNotFoundException {
        Game game=gameRepo.findById(idGame).orElse(null);
        
        if(game==null|| game.getDeletionDate()==null)
            throw new EntityNotFoundException(Game.class,"id",idGame.toString());
          
        return this.getModsGame(game);
    }

    public List<Mods> getModsGameByName(String nameGame) throws EntityNotFoundException {
        Game game=gameRepo.findByName(nameGame);
        if(game==null|| game.getDeletionDate()==null)
            throw new EntityNotFoundException(Game.class,"id",nameGame);
          
        return this.getModsGame(game);
    }
    
    private List<Mods> getModsGame(Game game) throws EntityNotFoundException{
        Game g=gameRepo.getOne(game.getId());
        if(g==null|| g.getDeletionDate()==null)
            throw new EntityNotFoundException(Game.class,"id",game.getId().toString());
        
        
        
        Mods filterBy=new Mods();
        filterBy.setGame(game);
        
        Example example=Example.of(filterBy);
        
        List<Mods> list=modRepo.findAll(example);
      
        return list;
        
    }

    public void deleteGame(Long idGame) throws EntityNotFoundException {
        Game game=gameRepo.findById(idGame).orElse(null);
        if(game==null)
             throw new EntityNotFoundException(Game.class,"id",idGame.toString());
        game.setDeletionDate(OffsetDateTime.now());
        gameRepo.save(game);
    }
}//endSercice
