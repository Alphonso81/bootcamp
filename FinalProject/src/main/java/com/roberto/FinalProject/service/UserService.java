/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.service;

import com.roberto.FinalProject.dao.UserRepository;
import com.roberto.FinalProject.errorHandler.EntityNotFoundException;
import com.roberto.FinalProject.model.User;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 *
 * @author roberto
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    
    public User saveUser(User user){
       
        return userRepo.save(user);
    }
    
    public User findUser(Long idUser) throws EntityNotFoundException {
        User user= userRepo.findById(idUser).orElse(null);
        if(user==null){
            throw new EntityNotFoundException(User.class,"id",idUser.toString());
        }       
        return user;
    }

    public void deleteUser(Long idUser) throws EntityNotFoundException {
        User user= userRepo.findById(idUser).orElse(null);
        if(user==null){
            throw new EntityNotFoundException(User.class,"id",idUser.toString());
        }
        userRepo.delete(user);        
    }

    public User updateUser(User user, Long idUser) throws EntityNotFoundException {
        User u= userRepo.findById(idUser).orElse(null);
        if(u==null){
            throw new EntityNotFoundException(User.class,"id",idUser.toString());
        }
        //repository.delete(u);  
        user.setId(idUser);
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
       
        return (List<User>)userRepo.findAll();
    }
}//endclass
