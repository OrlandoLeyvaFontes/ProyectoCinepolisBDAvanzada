/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Entidad.Peliculas;
import dtoCinepolis.PeliculasDTO;
import java.util.ArrayList;

/**
 *
 * @author Oley
 */
public interface IPeliculasDAO {

    public IConexionBD getConexionBD();

    void guardar(Peliculas pelicula) throws PersistenciaException;
    
    void eliminar(int id) throws PersistenciaException;
    
    void actualizar(Peliculas pelicula) throws PersistenciaException;

}
