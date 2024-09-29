/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Persistencia.CiudadesDAO;
import Persistencia.ClientesDAO;
import Persistencia.ConexionBD;
import Persistencia.IClientesDAO;
import Persistencia.PersistenciaException;
import Persistencia.SalasDAO;
import Persistencia.SucursalDAO;
import dtoCinepolis.ClientesDTO;
import dtoCinepolis.SalasDTO;
import dtoCinepolis.SucursalesDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Oley
 */
public class PruebasMain {
    public static void main(String[] args) throws NegocioException {
        try {
            // Crear instancia de la conexión a la base de datos
            ConexionBD conexionBD = new ConexionBD();
            // Crear instancia de ClientesDAO
            IClientesDAO clientesDAO = new ClientesDAO(conexionBD);
            IClientesNegocios clientesNegocios = new ClientesNegocio(clientesDAO);
            
            // Crear un objeto ClientesDTO para editar
            ClientesDTO clienteDTO = new ClientesDTO();
            clienteDTO.setId(1); // Asegúrate de establecer el ID correcto
            clienteDTO.setNombre("Juan");
            clienteDTO.setApellidoPaterno("Pérez");
            clienteDTO.setApellidoMaterno("González");
            clienteDTO.setFechaNacimiento(LocalDate.of(1990, 5, 20));
            clienteDTO.setCorreo("juan.perez@example.com");
            clienteDTO.setContraseña("12345");
            clienteDTO.setCiudad("Ciudad de México");

            // Llamar al método editar
            clientesNegocios.editar(clienteDTO);
            System.out.println("Cliente editado exitosamente.");
        } catch (NegocioException e) {
            System.out.println("Error en la lógica de negocio: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}
