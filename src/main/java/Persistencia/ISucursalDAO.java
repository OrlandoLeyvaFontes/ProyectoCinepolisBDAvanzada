/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidad.Sucursales;

/**
 *
 * @author Oley
 */
public interface ISucursalDAO {
    void guardar(Sucursales sucursal) throws PersistenciaException;
}
