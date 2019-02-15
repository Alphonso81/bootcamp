/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.model;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author roberto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Description {
    private String webDescription;
    private String mobileDescription;
}
