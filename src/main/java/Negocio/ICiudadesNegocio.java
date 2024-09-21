/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidad.Ciudad;
import Persistencia.PersistenciaException;
import dtoCinepolis.CiudadesDTO;

/**
 *
 * @author Oley
 */
public interface ICiudadesNegocio {

    CiudadesDTO guardar(CiudadesDTO ciudad) throws PersistenciaException;
}
