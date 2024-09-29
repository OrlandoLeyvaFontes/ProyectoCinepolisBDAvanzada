/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Persistencia.PersistenciaException;
import dtoCinepolis.SucursalTablaDTO;
import dtoCinepolis.SucursalesDTO;
import dtoCinepolis.SucursalesFiltroTablaDTO;
import java.util.List;

/**
 *
 * @author Oley
 */
public interface ISucursalesNegocio {

    void guardarSucursalConCiudadPorNombre(SucursalesDTO sucursalDTO, String nombreCiudad) throws NegocioException;

    public SucursalesDTO buscarSucursalPorNombre(String nombre) throws NegocioException;
    List<SucursalesDTO> buscarSucursal(SucursalesFiltroTablaDTO filtro) throws NegocioException;
    List<SucursalTablaDTO> buscarSucursalesTabla(SucursalesFiltroTablaDTO sucursalesFiltroTablaDTO) throws NegocioException ;
}
