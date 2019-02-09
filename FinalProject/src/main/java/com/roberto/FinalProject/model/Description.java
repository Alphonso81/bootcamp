/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author roberto
 */
@Embeddable
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Description extends BaseEntity implements Serializable{
    private String webDescription;
    private String mobileDescription;
    
    public Description(Long id, OffsetDateTime creationDate, OffsetDateTime editionDate, OffsetDateTime deletionDate,String web,String mob){
     super(id,creationDate,editionDate,deletionDate);
     this.mobileDescription=mob;
     this.webDescription=web;
    }
}
