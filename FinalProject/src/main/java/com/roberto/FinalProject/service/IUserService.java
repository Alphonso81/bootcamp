/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.service;

import com.roberto.FinalProject.model.User;
import java.util.List;

/**
 *
 * @author roberto
 */
public interface IUserService {
    
    User findUser(Long idUser);
    
    List<User> findAll();
    
    void deleteById(Long userId);
    
    User updateById(Long userId);
    
    User saveUser(User user);
    
    
     
}
