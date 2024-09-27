/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Entidad.Funciones;
import dtoCinepolis.FuncionesDTO;
import dtoCinepolis.FuncionesFiltroTablaDTO;
import dtoCinepolis.FuncionesTablaDTO;
import java.util.List;

/**
 *
 * @author aleja
 */
public interface IFuncionesDAO {

    Funciones guardar(Funciones funcion) throws PersistenciaException;

    Funciones eliminar(int id) throws PersistenciaException;

     public Funciones buscarPorId(int id) throws PersistenciaException;

    List<FuncionesTablaDTO> buscarFuncionesTabla(FuncionesFiltroTablaDTO filtro) throws PersistenciaException;

    public List<FuncionesDTO> buscarFunciones(FuncionesFiltroTablaDTO filtro);
}
