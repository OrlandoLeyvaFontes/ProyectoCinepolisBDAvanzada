/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import Entidad.Peliculas;
import Persistencia.PersistenciaException;
import dtoCinepolis.PeliculasDTO;
import dtoCinepolis.PeliculasFiltroTablaDTO;
import dtoCinepolis.PeliculasTablaDTO;
import dtoCinepolis.SucursalesFiltroTablaDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oley
 */
public interface IPeliculasNegocio {

     PeliculasDTO guardarPeliculas(PeliculasDTO peliculasDTO) throws PersistenciaException;

    List<PeliculasTablaDTO> buscarPeliculasTabla(PeliculasFiltroTablaDTO filtro) throws NegocioException;

    public void editar(PeliculasDTO peliculasDTO) throws NegocioException;

    PeliculasDTO eliminar(int id) throws NegocioException;

    public PeliculasDTO buscarPeliculasPorNombre(String nombrePelicula) throws NegocioException;
    
    public PeliculasDTO buscarPeliculasPorID(int id) throws NegocioException;
}
