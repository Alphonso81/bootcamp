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
import com.roberto.FinalProject.model.UserItem;
import com.roberto.FinalProject.model.dot.dotUserItem;
import com.roberto.FinalProject.service.UserItemService;
import com.roberto.FinalProject.validators.DotUserItemValidator;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author roberto
 */
@RestController
public class UserItemController {

    @Autowired
    private UserItemService uiService;

    @PostMapping("/BuyGame")
    public ResponseEntity buyGameForUser(@Valid @RequestBody dotUserItem dotUI) throws EntityNotFoundException {

        if (dotUI.getItem().getClass() != Game.class) {
                return new ResponseEntity("The item is not a Game",HttpStatus.BAD_REQUEST);
        }
            UserItem ui = uiService.saveUserItem(dotUI);

            return new ResponseEntity(ui, HttpStatus.CREATED);
    }
    
    @PostMapping("/BuyMod")
    public ResponseEntity buyModForUser(@Valid @RequestBody dotUserItem dotUI) throws EntityNotFoundException {

        if (dotUI.getItem().getClass() != Mods.class) {
                return new ResponseEntity("The item is not a Mod",HttpStatus.BAD_REQUEST);
        }
            UserItem ui = uiService.saveUserItem(dotUI);

            return new ResponseEntity(ui, HttpStatus.CREATED);
    }
    
    
    @GetMapping("/SearchGames/{idUser}")
    public ResponseEntity getAllGamesForUser(@PathVariable Long idUser) throws EntityNotFoundException{
        List<Item> list=uiService.getAllItemsForUser(idUser,"G");
        return new ResponseEntity(list, HttpStatus.FOUND);
    }
    
    @GetMapping("/SearchMods/{idUser}")
    public ResponseEntity getAllModsForUser(@PathVariable Long idUser) throws EntityNotFoundException{
        List<Item> list=uiService.getAllItemsForUser(idUser,"M");
        return new ResponseEntity(list, HttpStatus.FOUND);
    }
    
    //-------------------------------------------------
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new DotUserItemValidator());
        
    }
}//end
