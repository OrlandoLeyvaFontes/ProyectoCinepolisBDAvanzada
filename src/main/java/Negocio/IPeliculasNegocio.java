/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import Entidad.Peliculas;
import Persistencia.PersistenciaException;
import dtoCinepolis.PeliculasDTO;

/**
 *
 * @author Oley
 */
public interface IPeliculasNegocio {
         void guardar(PeliculasDTO peliculaDTO) throws  PersistenciaException;

}
