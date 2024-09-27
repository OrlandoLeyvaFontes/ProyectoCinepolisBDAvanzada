/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import Persistencia.PersistenciaException;
import dtoCinepolis.FuncionesDTO;
import dtoCinepolis.FuncionesFiltroTablaDTO;
import dtoCinepolis.FuncionesTablaDTO;
import java.util.List;

/**
 *
 * @author aleja
 */
public interface IFuncionesNegocio {

    FuncionesDTO guardar(FuncionesDTO funcionDTO) throws PersistenciaException;

    FuncionesDTO eliminar(int id) throws PersistenciaException;

    List<FuncionesTablaDTO> buscarFuncionesTabla(FuncionesFiltroTablaDTO filtro) throws NegocioException;
}
