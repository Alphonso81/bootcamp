/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.model;

import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author roberto
 */
@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor

public abstract class BaseEntity {
    @Id
    private Long id;
    @Column(updatable = false,insertable = false)
    private OffsetDateTime creationDate;
    @Column(updatable = false,insertable = false)
    private OffsetDateTime editionDate;
    @Column(updatable = false,insertable = false)
    private OffsetDateTime deletionDate;
}
