/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.roberto.FinalProject.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author roberto
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Long>{

    public Game findByName(String name);
    
}
