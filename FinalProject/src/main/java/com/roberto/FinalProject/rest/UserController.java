/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.rest;


import com.roberto.FinalProject.validators.UserValidator;
import com.roberto.FinalProject.model.User;
import com.roberto.FinalProject.service.UserService;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
public class UserController {
    
    @Autowired
    private UserService userService;
    
    private static final Logger logger=LogManager.getLogger(UserController.class);
   
  @PostMapping("/User")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
            logger.info("before the insert "+user);
		User u=userService.saveUser(user);
            logger.info("after the insert "+user);
		if(u!=null)
			return new ResponseEntity<>(user,HttpStatus.OK);
		return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
	}
        
    @GetMapping("/User/{idUser}")
    public User findUser(@PathVariable("idUser") long idUser){
        User user=userService.findUser(idUser);
        logger.info("after the search "+user);
      //  if(user!=null)
            return user;
       // return ResponseEntity.status(HttpStatus.NOT_FOUND).body(user);
    }
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
         binder.setValidator(new UserValidator());
}
}//endclass
