/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Presentacion;

import Entidad.Peliculas;
import Negocio.ClientesNegocio;
import Negocio.IClientesNegocios;
import Negocio.NegocioException;
import Negocio.PeliculasNegocio;
import Persistencia.ClientesDAO;
import Persistencia.ConexionBD;
import Persistencia.IClientesDAO;
import Persistencia.IConexionBD;
import Persistencia.PeliculasDAO;
import Persistencia.PersistenciaException;
import dtoCinepolis.ClientesDTO;
import dtoCinepolis.PeliculasDTO;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author rober
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) throws SQLException, PersistenciaException, NegocioException {
//        IConexionBD conexionBD = new ConexionBD();
//        IClientesDAO peliculasDAO = new ClientesDAO(conexionBD); // Asegúrate de tener una implementación de IPeliculasDAO
//
//        // Paso 2: Instanciar PeliculasNegocio
//        IClientesNegocios peliculasNegocio = new ClientesNegocio(peliculasDAO);
//
//        ClientesDTO clienteDTO = new ClientesDTO(
//                "Juan", // nombre
//                "Pérez", // apellidoPaterno
//                "García", // apellidoMaterno
//                LocalDate.of(1990, 5, 15), // fechaNacimiento (LocalDate)
//                "juan.perez@example.com", // correo
//                "password123", // contraseña
//                "Ciudad de México" // ciudad
//        );
//        clienteDTO.setId(1);
//        
//        peliculasNegocio.editarCliente(clienteDTO);
//    }

}
