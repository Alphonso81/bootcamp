/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.service;

import com.roberto.FinalProject.dao.UserRepository;
import com.roberto.FinalProject.errorHandler.EntityNotFoundException;
import com.roberto.FinalProject.model.User;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.criterion.Example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;

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
        user.setCreationDate(OffsetDateTime.now());
        return userRepo.save(user);
    }
    
    public User findUserById(Long idUser) throws EntityNotFoundException {
        User user= userRepo.findById(idUser).orElse(null);
        
        if(user==null||user.getDeletionDate()!=null){
            throw new EntityNotFoundException(User.class,"id",idUser.toString());
        }       
        return user;
    }

    public void deleteUser(Long idUser) throws EntityNotFoundException {
        User user= userRepo.findById(idUser).orElse(null);
        if(user==null){
            throw new EntityNotFoundException(User.class,"id",idUser.toString());
        }
        user.setDeletionDate(OffsetDateTime.now());
        userRepo.save(user);
        //userRepo.delete(user);        
    }

    public User updateUser(User user) throws EntityNotFoundException {
        User u= userRepo.findById(user.getId()).orElse(null);
        if(u==null){
            throw new EntityNotFoundException(User.class,"id",user.getId().toString());
        }
        user.setEditionDate(OffsetDateTime.now());
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
    
      List<User> lst=userRepo.findAll();
      List<User> result=new ArrayList<>();
      
      for(User u:lst){
          if(u.getDeletionDate()==null)
              result.add(u);
      }
      return result;
    
     // return userRepo.getAllUser();
    }

    public User findUserByName(String nameUser) throws EntityNotFoundException {
        User user=userRepo.findByName(nameUser);
        if(user==null||user.getDeletionDate()!=null)
            throw new EntityNotFoundException(User.class,"name",nameUser);
            
       return user;
    }
}//endclass
