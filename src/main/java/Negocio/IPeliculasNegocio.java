/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import Entidad.Peliculas;
import Persistencia.PersistenciaException;
import dtoCinepolis.PeliculasDTO;
import java.util.ArrayList;


/**
 *
 * @author Oley
 */
public interface IPeliculasNegocio {
    public void guardar(PeliculasDTO peliculaDTO) throws NegocioException;

}
