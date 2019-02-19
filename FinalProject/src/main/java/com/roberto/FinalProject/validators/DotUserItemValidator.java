/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.validators;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.roberto.FinalProject.model.dot.dotUserItem;

/**
 *
 * @author roberto
 */
public class DotUserItemValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return dotUserItem.class.equals(clazz);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void validate(Object target, Errors errors) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        dotUserItem dot=(dotUserItem)target;
        
        if(dot.item==null){
            errors.rejectValue("item", "item.empty");
        }
        if( dot.user==null){
            errors.rejectValue("user", "user.empty");
        }
        
        
    }//end
    
}
