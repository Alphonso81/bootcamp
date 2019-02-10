/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author roberto
 */
@Entity
@Data
@NoArgsConstructor
@IdClass(UserItemPk.class)
public class UserItem {
       
    @Id
    private Long userId;
    @Id
    private Long itemId;

   // @ManyToOne
  //  @JoinColumn
  //  private User user;

   // @ManyToOne
  //  @JoinColumn
   // private Item item;
}
