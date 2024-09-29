/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author Oley
 */
public class Ciudad {

    int id;
    String nombre;
     boolean estaEliminado;

    public Ciudad() {
    }

    public Ciudad(int id, String nombre, boolean estaEliminado) {
        this.id = id;
        this.nombre = nombre;
        this.estaEliminado = estaEliminado;
    }

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }

    public Ciudad(int aInt, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstaEliminado() {
        return estaEliminado;
    }

    public void setEstaEliminado(boolean estaEliminado) {
        this.estaEliminado = estaEliminado;
    }

    
}
