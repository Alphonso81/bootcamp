/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.service;

import com.roberto.FinalProject.dao.UserItemRepository;
import com.roberto.FinalProject.model.UserItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author roberto
 */
@Service
public class UserItemService {
    @Autowired
    private UserItemRepository uiRepo;
    
    public UserItem saveUserItem(UserItem ui){
        return uiRepo.save(ui);
    }
}
