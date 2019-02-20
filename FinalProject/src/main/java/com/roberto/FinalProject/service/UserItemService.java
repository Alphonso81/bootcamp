/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.service;

import com.roberto.FinalProject.dao.ItemRepository;
import com.roberto.FinalProject.dao.UserItemRepository;
import com.roberto.FinalProject.dao.UserRepository;
import com.roberto.FinalProject.errorHandler.EntityNotFoundException;
import com.roberto.FinalProject.model.Item;
import com.roberto.FinalProject.model.User;
import com.roberto.FinalProject.model.UserItem;
import com.roberto.FinalProject.model.UserItemPk;
import com.roberto.FinalProject.model.dot.dotUserItem;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 *
 * @author roberto
 */
@Service
public class UserItemService {

    @Autowired
    private UserItemRepository uiRepo;

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    public UserItem saveUserItem(dotUserItem dotUI) throws EntityNotFoundException {
        User user = userService.findUserById(dotUI.getUser().getId());
        Item item = itemService.findItem(dotUI.getItem().getId());

        if (user == null || user.getDeletionDate() == null) {
            throw new EntityNotFoundException(User.class, "id", user.getId().toString());
        }

        if (item == null || item.getDeletionDate() == null) {
            throw new EntityNotFoundException(Item.class, "id", item.getId().toString());
        }
        //--------------------------------------------------------------
        UserItemPk uiPk = new UserItemPk(user.getId(), item.getId());

        UserItem ui = new UserItem(uiPk, user, item);

        return uiRepo.save(ui);
    }

    public List<Item> getAllItemsForUser(Long idUser, String type) throws EntityNotFoundException {
        User user = userService.findUserById(idUser);

        if (user == null || user.getDeletionDate() != null) {
            throw new EntityNotFoundException(User.class, "name", idUser.toString());
        }

        Item item = new Item();
        item.setItemType(type);

        UserItem ui = new UserItem();
        ui.setUser(user);
        ui.setItem(item);

        Example example = Example.of(ui);
        List<UserItem> list = uiRepo.findAll(example);

        List<Item> result = new ArrayList<>();
        for (UserItem i : list) {
            result.add(i.getItem());
        }
        return result;
    }

}//end
