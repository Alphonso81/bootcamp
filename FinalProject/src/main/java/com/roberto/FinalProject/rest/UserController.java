/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.rest;

import com.roberto.FinalProject.errorHandler.EntityNotFoundException;
import com.roberto.FinalProject.validators.UserValidator;
import com.roberto.FinalProject.model.User;
import com.roberto.FinalProject.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author roberto
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @PostMapping("/Users")
    public ResponseEntity saveUser(@Valid @RequestBody User user) {
       
        User u = userService.saveUser(user);
       
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @PutMapping("/Users")
    public ResponseEntity updateUser(@Valid @RequestBody User user)throws EntityNotFoundException{
        User u = userService.updateUser(user);
       return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @GetMapping("/Users/Id/{idUser}")
    public ResponseEntity findUserById(@PathVariable("idUser") Long idUser) throws EntityNotFoundException {
        User user=userService.findUserById(idUser);
        return new ResponseEntity(user, HttpStatus.OK);
    }
   
    @GetMapping("/Users/Name/{nameUser}")
    public ResponseEntity findUserByName(@PathVariable("nameUser") String nameUser) throws EntityNotFoundException {
        User user=userService.findUserByName(nameUser);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @DeleteMapping("/User/{idUser}")
    public ResponseEntity<User> deleteUser(@PathVariable("idUser") Long idUser) throws EntityNotFoundException {
        userService.deleteUser(idUser);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/Users")
    public ResponseEntity getUsers(){
        List<User> list= userService.getAllUsers();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
 
    //-------------------------------------------------
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new UserValidator());
        
    }
}//endclass
