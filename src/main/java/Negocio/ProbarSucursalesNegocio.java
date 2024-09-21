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
            IConexionBD conexionBD = new ConexionBD();

            SucursalDAO sucursalDAO = new SucursalDAO(conexionBD);
            SucursalesNegocio sucursalesNegocio = new SucursalesNegocio(sucursalDAO);

            SucursalesDTO nuevaSucursalDTO = new SucursalesDTO();
            nuevaSucursalDTO.setNombre("ITCason");
            
            CiudadesDTO ciudadDTO = new CiudadesDTO();
            ciudadDTO.setId(1);  
            ciudadDTO.setNombre("Obregón");

            nuevaSucursalDTO.setCiudad(ciudadDTO.getNombre());

            sucursalesNegocio.guardar(nuevaSucursalDTO);

            System.out.println("Sucursal guardada exitosamente.");

        } catch (PersistenciaException e) {
            System.out.println("Error al guardar la sucursal: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
}
}

