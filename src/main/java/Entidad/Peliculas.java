/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author Oley
 */
public class Peliculas {

    int id;
    String titulo;
    String clasificacion;
    String genero;
    int duracionMinutos;
    String paisOrigen;
    String texto;

    public Peliculas() {
    }

    public Peliculas(int id, String titulo, String clasificacion, String genero, int duracionMinutos, String paisOrigen, String texto) {
        this.id = id;
        this.titulo = titulo;
        this.clasificacion = clasificacion;
        this.genero = genero;
        this.duracionMinutos = duracionMinutos;
        this.paisOrigen = paisOrigen;
        this.texto = texto;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = this.titulo;
    }

    public String getClasificacion() {
        return this.clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = this.clasificacion;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = this.genero;
    }

    public int getDuracionMinutos() {
        return this.duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = this.duracionMinutos;
    }

    public String getPaisOrigen() {
        return this.paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = this.paisOrigen;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = this.texto;
    }
    
    
    
    
    
    
}
