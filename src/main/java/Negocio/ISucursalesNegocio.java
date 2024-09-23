/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Persistencia.PersistenciaException;
import dtoCinepolis.SucursalesDTO;

/**
 *
 * @author Oley
 */
public interface ISucursalesNegocio {
     void guardarSucursalConCiudadPorNombre(SucursalesDTO sucursalDTO, String nombreCiudad) throws NegocioException;

}
