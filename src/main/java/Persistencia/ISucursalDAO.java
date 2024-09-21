/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidad.Ciudad;
import Entidad.Sucursales;

/**
 *
 * @author Oley
 */
public interface ISucursalDAO {
public void guardar(Sucursales sucursal, Ciudad ciudad) throws PersistenciaException;
}
