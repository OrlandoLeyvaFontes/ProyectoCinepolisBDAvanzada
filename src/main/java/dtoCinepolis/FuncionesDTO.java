/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtoCinepolis;

import Entidad.Salas;
import java.time.LocalTime;

/**
 *
 * @author aleja
 */
public class FuncionesDTO {

    String nombre;
    int costo;
    LocalTime horaInicio;
    boolean estaEliminado;
    Salas salas;

    public FuncionesDTO(String nombre, int costo, LocalTime horaInicio, boolean estaEliminado, Salas salas) {
        this.nombre = nombre;
        this.costo = costo;
        this.horaInicio = horaInicio;
        this.estaEliminado = estaEliminado;
        this.salas = salas;
    }

    public FuncionesDTO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public boolean isEstaEliminado() {
        return estaEliminado;
    }

    public void setEstaEliminado(boolean estaEliminado) {
        this.estaEliminado = estaEliminado;
    }

    public Salas getSalas() {
        return salas;
    }

    public void setSalas(Salas salas) {
        this.salas = salas;
    }
    
    
}
