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
public class PruebaSucursal {
    public static void main(String[] args) throws PersistenciaException {
        
    
  IConexionBD conexionBD=new ConexionBD();
  SucursalDAO surcursalDAO=new SucursalDAO(conexionBD);
  Sucursales sucursales=new Sucursales( "itcason", "dubai");
  surcursalDAO.guardar(sucursales);
}
}