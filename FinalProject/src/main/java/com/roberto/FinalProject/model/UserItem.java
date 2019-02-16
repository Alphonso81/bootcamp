/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author roberto
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserItem implements Serializable {
   
    @EmbeddedId
    private UserItemPk userItemPk;
    
    @MapsId("userId")
    @ManyToOne
    private User user;
    
    @MapsId("itemId")
    @ManyToOne
    private Item item;
}
