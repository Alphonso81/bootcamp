/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.rest;


import com.roberto.FinalProject.model.User;
import com.roberto.FinalProject.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

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
	public String saveUser(@RequestBody User user) {
            logger.info("before the insert "+user);
		User u=userService.saveUser(user);
            logger.info("after the insert "+user);
		if(u!=null)
			return "Success!!";
		return "FAIL!";
	}
}//endclass
