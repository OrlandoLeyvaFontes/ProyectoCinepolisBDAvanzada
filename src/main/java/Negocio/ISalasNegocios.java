/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import dtoCinepolis.SalaFiltroTablaDTO;
import dtoCinepolis.SalasDTO;
import dtoCinepolis.SalasTablaDTO;
import dtoCinepolis.SucursalesDTO;
import java.util.List;

/**
 *
 * @author Oley
 */
public interface ISalasNegocios {
    void guardarSucursalesConSalas(SalasDTO salasDTO , String nombre ) throws NegocioException;
    
    List<SalasTablaDTO> buscarSalaTabla(SalaFiltroTablaDTO filtro) throws NegocioException;
    
    void editar(SalasDTO salasDTO) throws NegocioException;
    
    SalasDTO eliminar(int id) throws NegocioException;
    
    SalasDTO buscarCiudadesPorNombre(String nombreSala) throws NegocioException;
    
    
    
}
