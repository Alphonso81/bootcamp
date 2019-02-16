/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.service;

import com.roberto.FinalProject.model.Mods;
import java.util.List;

/**
 *
 * @author roberto
 */
public interface IModService {

    Mods findById(Long modId);

    List<Mods> findAll();

    void deleteById(Long modId);

    Mods updateById(Long modId);

    void saveUser(Mods mod);
}
