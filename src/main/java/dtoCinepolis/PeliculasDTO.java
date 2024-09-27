/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtoCinepolis;

/**
 *
 * @author Oley
 */
public class PeliculasDTO {

    int id;
    String titulo;
    String clasificacion;
    String genero;
    int duracionMinutos;
    String paisOrigen;
    String texto;
    String linkTrailer;
    String sinopsis;

    public PeliculasDTO() {
    }

    public PeliculasDTO(String titulo, String clasificacion, String genero, int duracionMinutos, String paisOrigen, String texto, String linkTrailer) {
        this.titulo = titulo;
        this.clasificacion = clasificacion;
        this.genero = genero;
        this.duracionMinutos = duracionMinutos;
        this.paisOrigen = paisOrigen;
        this.texto = texto;
        this.linkTrailer = linkTrailer;
        this.sinopsis=sinopsis;
    }

    public PeliculasDTO(int id, String titulo, String clasificacion, String genero, int duracionMinutos, String paisOrigen, String texto) {
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
        return this.id;
    }

    public void setId(int id) {
        this.id = this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getClasificacion() {
        return this.clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracionMinutos() {
        return this.duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public String getPaisOrigen() {
        return this.paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getTexto() {
        return this.texto;
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

}
