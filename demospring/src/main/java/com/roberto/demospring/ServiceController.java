/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.demospring;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BootCamp
 */
@RestController
public class ServiceController {
   
    @RequestMapping(value="/greeting/{name}",method=RequestMethod.GET)
    public String greeting(@RequestParam(value="company")String company,
            @PathVariable(value="name")String name){
        return "Hola "+name+" bienvenid@ a "+company;
    }
    
    @RequestMapping(value="/message",method=RequestMethod.POST)
    public String greeting(@RequestBody String body){
        return body;
    }
}//endclass
