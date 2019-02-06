/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.FinalProject.validators;

import com.roberto.FinalProject.model.User;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author roberto
 */

public class UserValidator implements Validator{
   
    @Override
    public boolean supports(Class<?> clazz) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        User user=(User) target;
       
        if(checkInputString(user.getName())){
            errors.rejectValue("name", "name.empty");
        }
        if(checkInputString(user.getEmail())){
            errors.rejectValue("email", "email.empty");            
        }
        if(checkInputInteger(user.getDni())){
            errors.rejectValue("dni", "dni.empty");            
        }
    }
    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
    private boolean checkInputInteger(int input) {
        return (input == 0);
    }
}//endclass
