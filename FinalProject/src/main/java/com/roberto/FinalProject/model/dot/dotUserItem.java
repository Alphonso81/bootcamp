/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.model.dot;

import com.roberto.FinalProject.model.Item;
import com.roberto.FinalProject.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author roberto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class dotUserItem {
    public Item item;
    public User user;
}
