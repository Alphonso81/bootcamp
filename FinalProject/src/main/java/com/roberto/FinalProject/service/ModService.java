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
import com.roberto.FinalProject.model.dot.dotModToGame;
import java.time.OffsetDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 *
 * @author roberto
 */
@Service
public class ModService {
    @Autowired
    private ModRepository modRepo;
    @Autowired
    private GameRepository gameRepo;
    
    public Iterable<Mods> getAllMods(){
        return modRepo.findAll();       
    }

    public Mods saveMod(Mods mod) {
        mod.setCreationDate(OffsetDateTime.now());
       return modRepo.save(mod);
    }

    public Mods getModById(Long idMod) throws EntityNotFoundException {
        Mods mod=modRepo.findById(idMod).orElse(null);
        if(mod==null)
            throw new EntityNotFoundException(Mods.class, "id",idMod.toString());
       return mod; 
    }

    public Mods findModByName(String name)  throws EntityNotFoundException{
        
        Mods filter=new Mods();
        filter.setName(name);
        
        Example example=Example.of(filter);
        
        Mods result=(Mods)modRepo.findOne(example).orElse(null);
        
        if(result==null)
            throw new EntityNotFoundException(Mods.class,"name",name);
        
        return result;
    }

    public Mods updateMod(Mods mod) throws EntityNotFoundException {
         Mods newMod=modRepo.findById(mod.getId()).orElse(null);
        if(newMod==null)
           throw new EntityNotFoundException(Mods.class,"id",mod.getId().toString());
        mod.setEditionDate(OffsetDateTime.now());
        
        return modRepo.save(mod);
    }

    public Mods updateModToGame(dotModToGame dotMG)throws EntityNotFoundException  {
        Mods mod=modRepo.findById(dotMG.mod.getId()).orElse(null);
        Game game=gameRepo.findById(dotMG.game.getId()).orElse(null);
        
        if(mod==null)
            throw new EntityNotFoundException(Mods.class, "id",dotMG.mod.getId().toString());
        if(game==null)
            throw new EntityNotFoundException(Game.class, "id",dotMG.game.getId().toString());
        
        mod.setGame(game);
        
        return saveMod(mod);
    }
    
    
    
    
}//end
