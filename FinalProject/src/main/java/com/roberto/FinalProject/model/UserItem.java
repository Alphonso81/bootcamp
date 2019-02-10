/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author roberto
 */
//@IdClass(UserItemPk.class)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserItem implements Serializable {

    private static final long serialVersionUID = 1L;
    //private Long userId;
    //private Long itemId;
    @Id
    private Long userItemId;
    
    
    @ManyToOne
    @JoinColumn
    private Mod itemMod;
    
    @ManyToOne
    @JoinColumn
    private Game itemGame;

    
    @ManyToOne
    @JoinColumn
    private User user;

    
}
