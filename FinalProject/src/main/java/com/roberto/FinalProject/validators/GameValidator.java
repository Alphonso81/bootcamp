/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.validators;

import com.roberto.FinalProject.model.Game;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author roberto
 */
public class GameValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return Game.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Game game=(Game)target;
        
        if(checkedInputString(game.getName())){
            errors.rejectValue("name", "name.empty");
        }
        
        if(checkedInputString(game.getDescription().getMobileDescription())){
            errors.rejectValue("mobileDescription", "mobileDescription.empty");
        }
        
        if(checkedInputString(game.getDescription().getWebDescription())){
            errors.rejectValue("webDescription", "webDescription.empty");
        }
    }//end

    private boolean checkedInputString(String input) {
         return (input == null || input.trim().length() == 0);
    }
    
}
