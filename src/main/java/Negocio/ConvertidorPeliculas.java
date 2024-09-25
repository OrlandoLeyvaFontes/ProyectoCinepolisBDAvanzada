package Negocio;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import Entidad.Peliculas;
import dtoCinepolis.PeliculasDTO;

/**
 *
 * @author rober
 */
public class ConvertidorPeliculas {

    public ConvertidorPeliculas() {
    }
    public Peliculas DTOaEntidad(PeliculasDTO peliculasDTO) {
        Peliculas pelicula = new Peliculas();
        pelicula.setTitulo(peliculasDTO.getTitulo());
        pelicula.setClasificacion(peliculasDTO.getClasificacion());
        pelicula.setGenero(peliculasDTO.getGenero());
        pelicula.setPaisOrigen(peliculasDTO.getPaisOrigen());
        pelicula.setDuracionMinutos(peliculasDTO.getDuracionMinutos());
        pelicula.setTexto(peliculasDTO.getTexto());
        pelicula.setLinkTrailer(peliculasDTO.getLinkTrailer());
        return pelicula;
    }

    public PeliculasDTO EntidadADTO(Peliculas peliculas) {
        PeliculasDTO peliculasDTO = new PeliculasDTO();
        peliculasDTO.setTitulo(peliculas.getTitulo());
        peliculasDTO.setClasificacion(peliculas.getGenero());
        peliculasDTO.setGenero(peliculas.getClasificacion());
        peliculasDTO.setPaisOrigen(peliculas.getPaisOrigen());
        peliculasDTO.setDuracionMinutos(peliculas.getDuracionMinutos());
        peliculasDTO.setTexto(peliculas.getTexto());
        peliculasDTO.setLinkTrailer(peliculas.getLinkTrailer());
        return peliculasDTO;
    }
}
