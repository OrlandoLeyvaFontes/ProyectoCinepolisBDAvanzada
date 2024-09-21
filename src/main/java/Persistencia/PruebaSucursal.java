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
public class PruebaSucursal {
    public static void main(String[] args) throws PersistenciaException {
        
    
       
     try {
            IConexionBD conexionBD = new ConexionBD(); 
            SucursalDAO sucursalDAO = new SucursalDAO(conexionBD);

            Sucursales nuevaSucursal = new Sucursales("ITCason", "obregon");
            Ciudad ciudad = new Ciudad("obregon"); 

            sucursalDAO.guardar(nuevaSucursal, ciudad);

        } catch (PersistenciaException e) {
            System.out.println("Error al guardar la sucursal: " + e.getMessage());
        }
    }
    
}