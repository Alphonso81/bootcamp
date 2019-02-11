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
import org.hibernate.metamodel.model.convert.internal.JpaAttributeConverterImpl;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaPersistableEntityInformation;

/**
 *
 * @author roberto
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserItem implements Serializable{

    private static final long serialVersionUID = 1L;
 
    @Id
    @ManyToOne
    @JoinColumn
    private Item item;
    
    @Id    
    @ManyToOne
    @JoinColumn
    private User user;
   
}
