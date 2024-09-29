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

    private int id;
    private String titulo;
    private String clasificacion;
    private String genero;
    private String paisOrigen;
    private int duracionMinutos;
    private String sinopsis;
    private String linkTrailer;
    private String rutaImagen;
    private boolean estaEliminado = false;
    private int idFuncion;

    public PeliculasDTO() {
    }

    public PeliculasDTO(int id) {
        this.id = id;
    }

    public PeliculasDTO(String titulo) {
        this.titulo = titulo;
    }
    
    public PeliculasDTO(String titulo, String clasificacion, String genero, String paisOrigen, int duracionMinutos, String sinopsis, String linkTrailer) {
        this.titulo = titulo;
        this.clasificacion = clasificacion;
        this.genero = genero;
        this.paisOrigen = paisOrigen;
        this.duracionMinutos = duracionMinutos;
        this.sinopsis = sinopsis;
        this.linkTrailer = linkTrailer;
    }

    public PeliculasDTO(String titulo, String clasificacion, String genero, String paisOrigen, int duracionMinutos, String sinopsis, String linkTrailer, String rutaImagen) {
        this.titulo = titulo;
        this.clasificacion = clasificacion;
        this.genero = genero;
        this.paisOrigen = paisOrigen;
        this.duracionMinutos = duracionMinutos;
        this.sinopsis = sinopsis;
        this.linkTrailer = linkTrailer;
        this.rutaImagen = rutaImagen;
    }

    public PeliculasDTO(int id, String titulo, String clasificacion, String genero, String paisOrigen, int duracionMinutos, String sinopsis, String linkTrailer) {
        this.id = id;
        this.titulo = titulo;
        this.clasificacion = clasificacion;
        this.genero = genero;
        this.paisOrigen = paisOrigen;
        this.duracionMinutos = duracionMinutos;
        this.sinopsis = sinopsis;
        this.linkTrailer = linkTrailer;
    }

    public PeliculasDTO(int id, String titulo, String clasificacion, String genero, String paisOrigen, int duracionMinutos, String sinopsis, String linkTrailer, String rutaImagen) {
        this.id = id;
        this.titulo = titulo;
        this.clasificacion = clasificacion;
        this.genero = genero;
        this.paisOrigen = paisOrigen;
        this.duracionMinutos = duracionMinutos;
        this.sinopsis = sinopsis;
        this.linkTrailer = linkTrailer;
        this.rutaImagen = rutaImagen;
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

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
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

    public boolean isEstaEliminado() {
        return estaEliminado;
    }

    public void setEstaEliminado(boolean estaEliminado) {
        this.estaEliminado = estaEliminado;
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

}
