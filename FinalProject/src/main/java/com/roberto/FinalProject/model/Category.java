/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.model;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author roberto
 */
//@EqualsAndHashCode(exclude = "users")
@Entity
@Table(name="category")
public @Data class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="Description")
    private String description;
    
    //@OneToMany(mappedBy = "category")//, cascade = CascadeType.ALL)
   // private Set<User> users;
    /*
     public Category(String description, User... users) {
        this.description = description;
        this.users = Stream.of(users).collect(Collectors.toSet());
        this.users.forEach(x -> x.setCategory(this));
    }
    */
}//endclass
