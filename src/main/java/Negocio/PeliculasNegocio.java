/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidad.Peliculas;
import Persistencia.PersistenciaException;
import dtoCinepolis.PeliculasDTO;
import Persistencia.IPeliculasDAO;
import Persistencia.PeliculasDAO;

/**
 *
 * @author Oley
 */
public class PeliculasNegocio implements IPeliculasNegocio {
     
    private final IPeliculasDAO peliculaDAO;
    PeliculasDTO peliculasDTO;
    
    public PeliculasNegocio(IPeliculasDAO peliculasDAO) {
        this.peliculaDAO = peliculasDAO;
    }
    
    @Override
public void guardar(PeliculasDTO peliculaDTO) throws PersistenciaException {
    Peliculas pelicula = DTOaEntidad(peliculaDTO);
   
    peliculaDAO.guardar(pelicula);
}



    private Peliculas DTOaEntidad(PeliculasDTO peliculasDTO) {
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
}
