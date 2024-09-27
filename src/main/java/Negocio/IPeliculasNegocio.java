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
    ArrayList<PeliculasDTO> leer() throws NegocioException;
    public void guardar(PeliculasDTO peliculaDTO) throws NegocioException;
    void eliminar(int id) throws NegocioException;
    void actualizar(PeliculasDTO peliculaDTO) throws NegocioException;
}
