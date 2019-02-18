/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.service;

import com.roberto.FinalProject.dao.GameRepository;
import com.roberto.FinalProject.dao.ItemRepository;
import com.roberto.FinalProject.dao.ModRepository;

import com.roberto.FinalProject.errorHandler.EntityNotFoundException;
import com.roberto.FinalProject.model.Game;
import com.roberto.FinalProject.model.Item;
import com.roberto.FinalProject.model.Mods;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 *
 * @author roberto
 */
@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepo;

    @Autowired
    private GameRepository gameRepo;

    public Item saveItem(Item item) {

        return itemRepo.saveAndFlush(item);
    }

    public Item findItem(Long idItem) throws EntityNotFoundException {
        Item item = itemRepo.findById(idItem).orElse(null);
        if (item == null) {
            throw new EntityNotFoundException(Item.class, "id", idItem.toString());
        }
        return item;
    }

    public void deleteItem(Long idItem) throws EntityNotFoundException {
        Item item = itemRepo.findById(idItem).orElse(null);
        if (item == null) {
            throw new EntityNotFoundException(Item.class, "id", idItem.toString());
        }
        itemRepo.delete(item);
    }

    public Item updateItem(Item item, Long idItem) throws EntityNotFoundException {
        Item i = itemRepo.findById(idItem).orElse(null);
        if (i == null) {
            throw new EntityNotFoundException(Item.class, "id", idItem.toString());
        }

        item.setId(idItem);
        return itemRepo.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }

    public List<Item> getItemsByType(String type) {
        Item filter = new Item();
        filter.setItemType(type);

        Example<Item> example = Example.of(filter);

        return itemRepo.findAll(example);
    }

    

}//end
