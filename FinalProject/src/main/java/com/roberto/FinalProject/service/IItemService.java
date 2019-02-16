/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.service;

import com.roberto.FinalProject.model.Item;
import java.util.List;

/**
 *
 * @author roberto
 */
public interface IItemService {
    
    Item findById(Long itemId);
    
    List<Item> findAll();
    
    void deleteById(Long itemId);
    
    Item updateById(Long itemId);
    
    void saveUser(Item item);
    
}
