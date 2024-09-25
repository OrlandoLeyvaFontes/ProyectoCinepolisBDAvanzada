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

    ArrayList<PeliculasDTO> leer() throws PersistenciaException;

    void guardar(Peliculas pelicula) throws PersistenciaException;

    public void actualizar(Peliculas peliculas) throws PersistenciaException;

    void elimiar(int id) throws PersistenciaException;

}
