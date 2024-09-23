/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtoCinepolis;

import Entidad.Sucursales;
import java.time.LocalDateTime;

/**
 *
 * @author Oley
 */
public class SalasDTO {
     int id;
    String nombre;
    int cantidadAsientos;
    LocalDateTime tiempoLimpieza;
    SucursalesDTO sucursales;

  

    public SalasDTO() {
    }

    public SalasDTO(String nombre, int cantidadAsientos, LocalDateTime tiempoLimpieza, SucursalesDTO sucursales) {
        this.nombre = nombre;
        this.cantidadAsientos = cantidadAsientos;
        this.tiempoLimpieza = tiempoLimpieza;
        this.sucursales = sucursales;
    }

    public SalasDTO(int id, String nombre, int cantidadAsientos, LocalDateTime tiempoLimpieza, SucursalesDTO sucursales) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadAsientos = cantidadAsientos;
        this.tiempoLimpieza = tiempoLimpieza;
        this.sucursales = sucursales;
    }

    public SucursalesDTO getSucursales() {
        return sucursales;
    }

    public void setSucursales(SucursalesDTO sucursales) {
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
        this.id = id; 
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; 
    }

    public int getCantidadAsientos() {
        return this.cantidadAsientos;
    }

    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos; 
    }
}
