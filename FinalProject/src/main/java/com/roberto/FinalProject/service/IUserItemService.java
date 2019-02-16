/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.service;

import com.roberto.FinalProject.model.UserItem;
import java.util.List;

/**
 *
 * @author roberto
 */
public interface IUserItemService {
    
    UserItem findById(Long userItemId);

    List<UserItem> findAll();

    void deleteById(Long userItemId);

    UserItem updateById(Long userItemId);

    void saveUser(UserItem userItem);
}
