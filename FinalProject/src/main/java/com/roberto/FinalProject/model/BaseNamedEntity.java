/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.model;

import java.time.OffsetDateTime;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


/**
 *
 * @author roberto
 */
@MappedSuperclass
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class BaseNamedEntity extends BaseEntity {

    private String name;

    public BaseNamedEntity(Long id, OffsetDateTime creationDate, OffsetDateTime editionDate, OffsetDateTime deletionDate,String name) {
        super(id,creationDate,editionDate,deletionDate);
        this.name=name;
    }
}
