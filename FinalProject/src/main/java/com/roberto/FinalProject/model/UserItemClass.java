/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.model;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author roberto
 */
@Data
public class UserItemClass implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long userId;
    private Long itemId;
    
}
