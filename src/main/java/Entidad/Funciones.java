/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

import java.time.LocalTime;

/**
 *
 * @author aleja
 */
public class Funciones {

    String nombre;
    int costo;
    LocalTime horaInicio;
    boolean estaEliminado;
    Salas salas;

    public Funciones(String nombre, int costo, LocalTime horaInicio, boolean estaEliminado) {
        this.nombre = nombre;
        this.costo = costo;
        this.horaInicio = horaInicio;
        this.estaEliminado = false;
    }

    public Funciones(String nombre, int costo, LocalTime horaInicio, Salas salas, boolean estaEliminado) {
        this.nombre = nombre;
        this.costo = costo;
        this.horaInicio = horaInicio;
        this.salas = salas;
        this.estaEliminado = false;
    }

    public Salas getSalas() {
        return salas;
    }

    public void setSalas(Salas salas) {
        this.salas = salas;
    }

    public Funciones(String nombre, int costo, LocalTime horaInicio) {
        this.nombre = nombre;
        this.costo = costo;
        this.horaInicio = horaInicio;
    }

    public Funciones() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
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

}
