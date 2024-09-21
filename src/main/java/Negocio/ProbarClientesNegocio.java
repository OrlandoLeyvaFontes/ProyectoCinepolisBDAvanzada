/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Persistencia.ClientesDAO;
import Persistencia.ConexionBD;
import Persistencia.IConexionBD;
import Persistencia.PersistenciaException;
import Persistencia.SucursalDAO;
import dtoCinepolis.ClientesDTO;
import java.time.LocalDateTime;

/**
 *
 * @author Oley
 */
public class ProbarClientesNegocio {

    public static void main(String[] args) {
        
        try {
            IConexionBD conexionBD = new ConexionBD();
            ClientesDAO clientesDAO = new ClientesDAO(conexionBD);
            ClientesNegocio clientesNegocio = new ClientesNegocio(clientesDAO);
            
            ClientesDTO clientesDTO = new ClientesDTO();
            clientesDTO.setNombre("Juan");
            clientesDTO.setApellidoPaterno("Pérez");
            clientesDTO.setApellidoMaterno("Gómez");
            clientesDTO.setFechaNacimiento(LocalDateTime.of(1990, 5, 20, 0, 0));            
            clientesDTO.setCorreo("juan.perez@example.com");
            clientesDTO.setContraseña("contrasena123");            
            clientesDTO.setCiudad("Obregón");
            clientesNegocio.guardar(clientesDTO);
        } catch (PersistenciaException e) {
            System.out.println("Error al guardar la sucursal: " + e.getMessage());
            
        }
    }
}
