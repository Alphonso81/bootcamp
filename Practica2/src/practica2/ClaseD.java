/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

/**
 *
 * @author roberto
 */
public class ClaseD implements InterfazA,InterfazB{

    @Override
    public void metodoInterfazA() {
        System.out.println("Implementacion de la interfaz A en la ClaseD");
    }

    @Override
    public void metodoInterfazB() {
        System.out.println("Implementacion de la interfaz B en la ClaseD");
    }
    
}
