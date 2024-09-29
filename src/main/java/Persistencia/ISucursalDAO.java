/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidad.Ciudad;
import Entidad.Sucursales;
import dtoCinepolis.SucursalTablaDTO;
import dtoCinepolis.SucursalesFiltroTablaDTO;

import java.util.List;

/**
 *
 * @author Oley
 */
public interface ISucursalDAO {

    public void guardar(Sucursales sucursal) throws PersistenciaException;

    void editar(Sucursales sucursales) throws PersistenciaException;

    Sucursales buscarPorID(int id) throws PersistenciaException;

    Sucursales eliminar(int id) throws PersistenciaException;

     Sucursales buscarSucursalPorNombre(String nombre) throws PersistenciaException;

     List<Sucursales> buscarSucursal(SucursalesFiltroTablaDTO filtro) throws PersistenciaException;
}
