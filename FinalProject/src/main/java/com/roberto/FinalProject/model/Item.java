/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.model;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "id")
public abstract class Item extends BaseNamedEntity {

    @Embedded
    private Description description;

    /*
    @OneToMany(mappedBy = "item")
    private Set<UserItem> userItems;
    */
    public Item(Long id, OffsetDateTime creationDate, OffsetDateTime editionDate, OffsetDateTime deletionDate, String name, String web, String mob) {
        super(id, creationDate, editionDate, deletionDate, name);
        this.description = new Description(id, creationDate, editionDate, deletionDate, web, mob);
    }
}
