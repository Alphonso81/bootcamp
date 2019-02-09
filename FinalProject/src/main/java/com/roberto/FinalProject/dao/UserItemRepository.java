/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.dao;

import com.roberto.FinalProject.model.UserItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author roberto
 */
@Repository
public interface UserItemRepository extends JpaRepository<UserItem, Long> {
    
}
