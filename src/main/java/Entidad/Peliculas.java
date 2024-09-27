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
    String linkTrailer;
    String rutaImagen;
    String sinopsis;

    public Peliculas() {
    }

    public Peliculas(String titulo, String clasificacion, String genero) {
        this.titulo = titulo;
        this.clasificacion = clasificacion;
        this.genero = genero;
    }

    public Peliculas(String titulo, String clasificacion, String genero, int duracionMinutos, String paisOrigen, String texto, String linkTrailer, String rutaImagen, String Sinopsis) {
        this.titulo = titulo;
        this.clasificacion = clasificacion;
        this.genero = genero;
        this.duracionMinutos = duracionMinutos;
        this.paisOrigen = paisOrigen;
        this.texto = texto;
        this.linkTrailer = linkTrailer;
        this.rutaImagen = rutaImagen;
        this.sinopsis=sinopsis;
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

    
    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getLinkTrailer() {
        return linkTrailer;
    }

    public void setLinkTrailer(String linkTrailer) {
        this.linkTrailer = linkTrailer;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

}
