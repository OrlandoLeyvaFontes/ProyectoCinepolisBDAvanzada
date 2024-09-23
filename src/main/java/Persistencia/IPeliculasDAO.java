/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Entidad.Peliculas;

/**
 *
 * @author Oley
 */
public interface IPeliculasDAO {

    void guardar(Peliculas pelicula) throws PersistenciaException;
}
