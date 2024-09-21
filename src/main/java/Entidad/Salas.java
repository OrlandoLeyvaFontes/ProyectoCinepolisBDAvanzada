/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

import java.time.LocalDateTime;

/**
 *
 * @author Oley
 */
public class Salas {
    int id;
     String nombre;
     int cantidadAsientos;
    LocalDateTime tiempoLimpieza;
     
    public Salas() {
    }

    public Salas(int id, String nombre, int cantidadAsientos) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadAsientos = cantidadAsientos;
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

    public int getCantidadAsientos() {
        return this.cantidadAsientos;
    }

    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = this.cantidadAsientos;
    }
     
}
