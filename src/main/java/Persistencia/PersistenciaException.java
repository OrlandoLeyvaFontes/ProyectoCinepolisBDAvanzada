/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

/**
 *
 * @author Oley
 */
public class PersistenciaException extends  Exception{
    /*
      este es constructor es para mandar solo el mensaje
    */
    public PersistenciaException(String mensaje){
        super(mensaje);
    }
    /*
     ese contructor tiene un string y un problema
    */
    public  PersistenciaException(String mensaje, Throwable problema){
        super(mensaje,problema);
    }
    /*
     Constructor que solo tiene el problema
    */
    public  PersistenciaException(Throwable problema){
        super(problema);
    }
    
}
