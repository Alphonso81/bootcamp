/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
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
@Embeddable
public class UserItemPk implements Serializable {
    
    @Basic(optional = false)
    @Column(name="user_id")
    private Long userId;
    
    @Basic(optional = false)
    @Column(name = "item_id")
    private Long itemId;
}
