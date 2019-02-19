/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.validators;

import com.roberto.FinalProject.model.dot.dotModToGame;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author roberto
 */
public class ModToGameValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return dotModToGame.class.equals(clazz);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void validate(Object target, Errors errors) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        dotModToGame dot=(dotModToGame)target;
        
        if(dot.game==null){
            errors.rejectValue("game", "game.empty");
        }
        if(dot.mod==null){
            errors.rejectValue("mod", "mod.empty");
        }
        
        
    }//end
    
}
