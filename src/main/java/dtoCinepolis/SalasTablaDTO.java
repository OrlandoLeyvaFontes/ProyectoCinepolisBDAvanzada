/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtoCinepolis;

import java.time.LocalDateTime;

/**
 *
 * @author Oley
 */
public class SalasTablaDTO {

    String nombre;
    int cantidadAsientos;
    LocalDateTime tiempoLimpieza;
    Double CostoSugerido;

    public SalasTablaDTO() {
    }

    public SalasTablaDTO(String nombre, int cantidadAsientos, LocalDateTime tiempoLimpieza, Double CostoSugerido) {
        this.nombre = nombre;
        this.cantidadAsientos = cantidadAsientos;
        this.tiempoLimpieza = tiempoLimpieza;
        this.CostoSugerido = CostoSugerido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadAsientos() {
        return cantidadAsientos;
    }

    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }

    public LocalDateTime getTiempoLimpieza() {
        return tiempoLimpieza;
    }

    public void setTiempoLimpieza(LocalDateTime tiempoLimpieza) {
        this.tiempoLimpieza = tiempoLimpieza;
    }

    public Double getCostoSugerido() {
        return CostoSugerido;
    }

    public void setCostoSugerido(Double CostoSugerido) {
        this.CostoSugerido = CostoSugerido;
    }

}
