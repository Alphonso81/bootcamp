/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.rest;

import com.roberto.FinalProject.model.Game;
import com.roberto.FinalProject.model.Mods;
import com.roberto.FinalProject.model.User;
import com.roberto.FinalProject.model.UserItem;
import com.roberto.FinalProject.model.UserItemPk;
import com.roberto.FinalProject.service.GameService;
import com.roberto.FinalProject.service.ItemService;
import com.roberto.FinalProject.service.ModService;
import com.roberto.FinalProject.service.UserItemService;
import com.roberto.FinalProject.service.UserService;
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
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private ModService modService;
    @Autowired
    private GameService gameService;
    @Autowired
    private UserItemService uiService;

    @GetMapping("/test")
    public ResponseEntity test() {
        
        Game game = new Game();
        game.setName("soy un game");
        itemService.saveItem(game);
        
        Mods mod = new Mods();
        mod.setName("Soy un mod");
        mod.setGame(game);
        itemService.saveItem(mod);
        
        User user=new User();
        user.setName("Roberto");
        userService.saveUser(user);
        
        UserItem ui=new UserItem(new UserItemPk(user.getId(), mod.getId()), user, mod);
        uiService.saveUserItem(ui);
        //------------
        User user2=new User();
        user2.setName("Sebastian");
        userService.saveUser(user2);
        
        UserItem ui2=new UserItem();
        ui2.setUser(user2);
        ui2.setItem(game);
        UserItemPk uipk=new UserItemPk(user2.getId(), game.getId());
        ui2.setUserItemPk(uipk);
        uiService.saveUserItem(ui2);

        return new ResponseEntity("charged de items for the test", HttpStatus.CREATED);
    }
}
