/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Persistencia.PersistenciaException;
import dtoCinepolis.CiudadesDTO;
import dtoCinepolis.CuidadFiltroTablaDTO;
import dtoCinepolis.CuidadTablaDTO;
import java.util.List;

/**
 *
 * @author Oley
 */
public interface ICiudadesNegocio {

    CiudadesDTO guardar(CiudadesDTO ciudad) throws PersistenciaException;

    List< CuidadTablaDTO> buscarCuidadTabla(CuidadFiltroTablaDTO filtro) throws NegocioException;

    public void editar(CiudadesDTO ciudadesDTO) throws NegocioException;

    CiudadesDTO eliminar(int id) throws NegocioException;

    public CiudadesDTO buscarCiudadPorNombre(String nombreCiudad) throws NegocioException;

}
