/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author Oley
 */
public class Sucursales {
    int id;
    String nombre;
    String cuidad; 

    public Sucursales() {
    }

    public Sucursales(int id, String nombre, String cuidad) {
        this.id = id;
        this.nombre = nombre;
        this.cuidad = cuidad;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = this.nombre;
    }

    public String getCuidad() {
        return this.cuidad;
    }

    public void setCuidad(String cuidad) {
        this.cuidad = this.cuidad;
    }
    
    
}
