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
        
    
   // Suponiendo que tienes una implementación de IConexionBD
//        IConexionBD conexionBD = new ConexionBD(); // Asegúrate de que esta clase esté implementada correctamente
//        CiudadesDAO ciudadesDAO = new CiudadesDAO(conexionBD);
//
//        String nombreCiudadABuscar = "tucson"; // Cambia esto al nombre de la ciudad que deseas buscar
//
        try {
//            Ciudad ciudad = ciudadesDAO.buscarCiudadPorNombre(nombreCiudadABuscar);
//            if (ciudad != null) {
//                System.out.println("Ciudad encontrada: ID = " + ciudad.getId() + ", Nombre = " + ciudad.getNombre());
//            } else {
//                System.out.println("Ciudad no encontrada.");
//            }
//        } catch (PersistenciaException e) {
//            System.err.println("Error: " + e.getMessage());
//            e.printStackTrace();
//        }
            Ciudad ciudad = new Ciudad();
            ciudad.setId(2); 
            ciudad.setNombre("obregon");

            Sucursales sucursal = new Sucursales();
            sucursal.setNombre("Soriana");
            sucursal.setCiudad(ciudad);
             IConexionBD conexionBD= new ConexionBD();
            ISucursalDAO sucursalDAO = new SucursalDAO(conexionBD);

            sucursalDAO.guardar(sucursal);

        } catch (PersistenciaException e) {
            System.out.println("Error al guardar la sucursal: " + e.getMessage());
        }
    }
    
}