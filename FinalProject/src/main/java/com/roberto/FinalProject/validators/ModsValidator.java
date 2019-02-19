/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.validators;

import com.roberto.FinalProject.model.Mods;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author roberto
 */
public class ModsValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Mods.class.equals(clazz);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void validate(Object target, Errors errors) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Mods mod=(Mods)target;
        
        if(checkedInputString(mod.getName())){
            errors.rejectValue("name", "name.empty");
        }
        
    }//end
    //--------------------------
    
    private boolean checkedInputString(String input) {
         return (input == null || input.trim().length() == 0);
    }
    
}
