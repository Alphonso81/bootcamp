/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Set;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author roberto
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
//@DiscriminatorValue("Game")
public class Game extends Item implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @OneToMany(mappedBy = "game")
    private Set<Mod> mods;
    
    public Game(Long id, OffsetDateTime creationDate, OffsetDateTime editionDate, OffsetDateTime deletionDate,String name,String web,String mob){
        super(id,creationDate,editionDate,deletionDate,name,web,mob);       
    }
    
    @OneToMany(mappedBy = "itemGame")
    private Set<UserItem> userItems;
}//endclass
