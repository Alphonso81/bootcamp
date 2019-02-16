/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author roberto
 */
@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseNamedEntity implements Serializable {

    private String email;

    private int dni;
    
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<UserItem> userItems;
    
    
}//endClass
