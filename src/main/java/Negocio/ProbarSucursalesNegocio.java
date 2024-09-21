/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Persistencia.ConexionBD;
import Persistencia.IConexionBD;
import Persistencia.ISucursalDAO;
import Persistencia.PersistenciaException;
import Persistencia.SucursalDAO;
import dtoCinepolis.CiudadesDTO;
import dtoCinepolis.SucursalesDTO;

/**
 *
 * @author Oley
 */
public class ProbarSucursalesNegocio {
    public static void main(String[] args) throws PersistenciaException {
     try {
            // Crear la conexión a la base de datos
            IConexionBD conexionBD = new ConexionBD();

            // Crear la instancia del DAO
            SucursalDAO sucursalDAO = new SucursalDAO(conexionBD);
            SucursalesNegocio sucursalesNegocio = new SucursalesNegocio(sucursalDAO);

            // Crear la instancia de SucursalesDTO
            SucursalesDTO nuevaSucursalDTO = new SucursalesDTO();
            nuevaSucursalDTO.setNombre("ITCason");
            
            // Crear una instancia de CiudadDTO
            CiudadesDTO ciudadDTO = new CiudadesDTO();
            ciudadDTO.setId(1);  // Asigna el ID de la ciudad según corresponda
            ciudadDTO.setNombre("Obregón");

            // Establecer la ciudad en el DTO de sucursales
            nuevaSucursalDTO.setCiudad(ciudadDTO.getNombre());

            // Llamar al método guardar
            sucursalesNegocio.guardar(nuevaSucursalDTO);

            System.out.println("Sucursal guardada exitosamente.");

        } catch (PersistenciaException e) {
            System.out.println("Error al guardar la sucursal: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
}
}

