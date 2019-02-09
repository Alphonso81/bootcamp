/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.service;

import com.roberto.FinalProject.dao.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author roberto
 */
@Service
public class GameService {
    @Autowired
    private GameRepository repoGame;
}
