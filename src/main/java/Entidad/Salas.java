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
    Sucursales sucursales;
    LocalDateTime tiempoLimpieza;

    public Salas() {
    }

    public Salas(String nombre, int cantidadAsientos, Sucursales sucursales, LocalDateTime tiempoLimpieza) {
        this.nombre = nombre;
        this.cantidadAsientos = cantidadAsientos;
        this.sucursales = sucursales;
        this.tiempoLimpieza = tiempoLimpieza;
    }

    public Salas(int id, String nombre, int cantidadAsientos, Sucursales sucursales, LocalDateTime tiempoLimpieza) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadAsientos = cantidadAsientos;
        this.sucursales = sucursales;
        this.tiempoLimpieza = tiempoLimpieza;
    }

    public Sucursales getSucursales() {
        return sucursales;
    }

    public void setSucursales(Sucursales sucursales) {
        this.sucursales = sucursales;
    }

    public LocalDateTime getTiempoLimpieza() {
        return tiempoLimpieza;
    }

    public void setTiempoLimpieza(LocalDateTime tiempoLimpieza) {
        this.tiempoLimpieza = tiempoLimpieza;
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
