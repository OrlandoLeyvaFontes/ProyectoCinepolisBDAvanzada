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

     private int id;
    private String nombrePelicula;
    private LocalTime horaInicio;
    private double precio;
    private int sala;
    private boolean estaEliminado;

    public Funciones(int id, String nombrePelicula, LocalTime horaInicio, double precio, int sala, boolean estaEliminado) {
        this.id = id;
        this.nombrePelicula = nombrePelicula;
        this.horaInicio = horaInicio;
        this.precio = precio;
        this.sala = sala;
        this.estaEliminado = estaEliminado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public boolean isEstaEliminado() {
        return estaEliminado;
    }

    public void setEstaEliminado(boolean estaEliminado) {
        this.estaEliminado = estaEliminado;
    }
    
    
}