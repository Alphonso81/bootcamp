/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.service;

import com.roberto.FinalProject.dao.UserRepository;
import com.roberto.FinalProject.errorHandler.EntityNotFoundException;
import com.roberto.FinalProject.model.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author roberto
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;
   
    public User saveUser(User user) {
        return repository.save(user);
    }
    
    public User findUser(Long idUser) throws EntityNotFoundException {
        User user= repository.findById(idUser).orElse(null);
        if(user==null){
            throw new EntityNotFoundException(User.class,"id",idUser.toString());
        }
            
        return user;
    }
}//endclass
