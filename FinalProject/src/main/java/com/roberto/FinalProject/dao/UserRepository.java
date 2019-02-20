/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.dao;

import com.roberto.FinalProject.model.User;
import java.util.Collection;
import java.util.List;
import org.hibernate.criterion.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author roberto
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByName(String nameUser);

    
    
}
