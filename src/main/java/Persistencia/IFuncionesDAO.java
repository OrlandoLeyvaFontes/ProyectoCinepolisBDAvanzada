/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Entidad.Funciones;

/**
 *
 * @author aleja
 */
public interface IFuncionesDAO {

    Funciones guardar(Funciones funcion) throws PersistenciaException;

    Funciones eliminar(int id) throws PersistenciaException;

     public Funciones buscarPorId(int id) throws PersistenciaException;
}
