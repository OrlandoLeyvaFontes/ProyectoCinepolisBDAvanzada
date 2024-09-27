/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidad.Ciudad;
import Entidad.Clientes;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author Oley
 */
public class ProbarClientes {

    public static void main(String[] args) {
        ConexionBD conexionBD = new ConexionBD();
        ClientesDAO clientesDAO = new ClientesDAO(conexionBD);
        Ciudad ciudad = new Ciudad();
        ciudad.setId(1);

        Clientes clientes = new Clientes();
        clientes.setNombre("BATMAN");
        clientes.setApellidoPaterno("Pérez");
        clientes.setApellidoMaterno("García");
        String fechaNacimientoStr = "1990-01-01 00:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);
        clientes.setFechaNacimiento(fechaNacimiento);
        clientes.setCorreo("juan.perez@example.com");
        clientes.setContraseña("contrasena123");
//        clientes.setCiudad(ciudad);

        try {
            clientesDAO.guardar(clientes);
            System.out.println("Cliente guardado exitosamente.");
        } catch (PersistenciaException e) {
            System.err.println("Error al guardar el cliente: " + e.getMessage());
        }
    }
}
