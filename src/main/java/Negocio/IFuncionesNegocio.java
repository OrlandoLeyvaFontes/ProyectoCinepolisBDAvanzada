/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import Persistencia.PersistenciaException;
import dtoCinepolis.FuncionesDTO;

/**
 *
 * @author aleja
 */
public interface IFuncionesNegocio {

    FuncionesDTO guardar(FuncionesDTO funcionDTO) throws PersistenciaException;

    FuncionesDTO eliminar(int id) throws PersistenciaException;

    FuncionesDTO buscarPorNombre(String nombre) throws PersistenciaException;

}
