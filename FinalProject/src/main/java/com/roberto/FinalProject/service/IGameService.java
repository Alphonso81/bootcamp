/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.service;

import com.roberto.FinalProject.model.Game;
import java.util.List;

/**
 *
 * @author roberto
 */
public interface IGameService {

    Game findById(Long itemId);

    List<Game> findAll();

    void deleteById(Long gameId);

    Game updateById(Long gameId);

    void saveUser(Game game);

}
