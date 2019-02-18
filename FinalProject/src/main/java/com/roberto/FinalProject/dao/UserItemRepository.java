/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.dao;

import com.roberto.FinalProject.model.UserItem;
import com.roberto.FinalProject.model.UserItemPk;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author roberto
 */
@Repository
public interface UserItemRepository extends JpaRepository<UserItem, UserItemPk>{

    //public List<UserItem> findAllByUsersId(Long idUser);

    //public List<UserItem> findAllByUser(Long idUser);
    
}
