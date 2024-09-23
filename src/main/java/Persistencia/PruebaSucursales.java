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
public class PruebaSucursales {

    public static void main(String[] args) {
        ConexionBD conexionBD = new ConexionBD();

        SucursalDAO sucursalesPersistencia = new SucursalDAO(conexionBD);
        CiudadesDAO ciudadPersistencia = new CiudadesDAO(conexionBD);

        String nombreCiudad = "tucson";

        try {
            Ciudad ciudad = ciudadPersistencia.buscarCiudadPorNombre(nombreCiudad);

            Sucursales nuevaSucursal = new Sucursales();
            nuevaSucursal.setNombre("Sucursal Centro");
            nuevaSucursal.setCiudad(ciudad);

            sucursalesPersistencia.guardar(nuevaSucursal);
            System.out.println("Sucursal guardada exitosamente con la ciudad: " + ciudad.getId());

        } catch (PersistenciaException e) {
            e.printStackTrace();
        }
    }
}
