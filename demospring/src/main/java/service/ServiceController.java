/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BootCamp
 */
@RestController
public class ServiceController {
    
    @RequestMapping(value="/{empresa}",method=GET)
    public String greeting(@RequestParam(value="name",defaultValue="")String name){
        return 
    }
}
