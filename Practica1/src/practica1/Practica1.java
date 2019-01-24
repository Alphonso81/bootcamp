/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.ArrayList;
import otropackete.ClaseD;

/**
 *
 * @author roberto
 */
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        ArrayList<ClaseA> list= new ArrayList();
        
        list.add(new ClaseA());
        list.add(new ClaseB());
        list.add(new ClaseC());
        list.add(new ClaseD());
        
    
        for(ClaseA obj:list){
          if(obj.getClass()!= (new ClaseD()).getClass())
            System.out.println(((ClaseA)obj).whoiam());
             
        }
     
    }//finmain
    
}
