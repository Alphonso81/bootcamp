/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Table(name="mods")
public class Mod extends Item implements Serializable{
    private static final long serialVersionUID = 1L;
    @ManyToOne
    @JoinColumn
    private Game game;
    
    public Mod(Long id, OffsetDateTime creationDate, OffsetDateTime editionDate, OffsetDateTime deletionDate,String name,String web,String mob){
        super(id,creationDate,editionDate,deletionDate,name,web,mob);       
    }
}
