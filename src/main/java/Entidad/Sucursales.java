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
    Ciudad ciudad;
    private boolean estaEliminado;

    public Sucursales() {
    }

    public Sucursales(String nombre, Ciudad ciudad, boolean estaEliminado) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estaEliminado = estaEliminado;
    }

    public Sucursales(int id, String nombre, Ciudad ciudad, boolean estaEliminado) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estaEliminado = estaEliminado;
    }

    public Sucursales(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

 

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public boolean isEstaEliminado() {
        return estaEliminado;
    }

    public void setEstaEliminado(boolean estaEliminado) {
        this.estaEliminado = estaEliminado;
    }

}
