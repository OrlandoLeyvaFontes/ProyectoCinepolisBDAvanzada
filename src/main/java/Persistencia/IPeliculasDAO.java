/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Entidad.Peliculas;
import dtoCinepolis.PeliculasDTO;
import dtoCinepolis.PeliculasFiltroTablaDTO;
import dtoCinepolis.PeliculasTablaDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oley
 */
public interface IPeliculasDAO {

    public Peliculas guardar(Peliculas peliculas) throws PersistenciaException;

    List<PeliculasTablaDTO> buscarPelicula(PeliculasFiltroTablaDTO filtro) throws PersistenciaException;

    void editar(Peliculas peliculas) throws PersistenciaException;

    Peliculas buscarPorID(int id) throws PersistenciaException;

    Peliculas eliminar(int id) throws PersistenciaException;

    public Peliculas buscarPeliculasPorNombre(String nombrePelicula) throws PersistenciaException;

}
