/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.model;

import java.io.Serializable;
import java.time.OffsetDateTime;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author roberto
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseNamedEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String email;
    private int dni;

    @OneToMany(mappedBy = "user")
    private Set<UserItem> userItems;
    
    
    public User(Long id, OffsetDateTime creationDate, OffsetDateTime editionDate, OffsetDateTime deletionDate, String name, String email, int dni) {
        super(id, creationDate, editionDate, deletionDate, name);
        this.email = email;
        this.dni = dni;
    }

}//endClass
