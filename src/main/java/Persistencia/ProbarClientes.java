/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidad.Ciudad;
import Entidad.Clientes;
import java.time.LocalDateTime;

/**
 *
 * @author Oley
 */
public class ProbarClientes {
    public static void main(String[] args) {
    IConexionBD conexionBD=new ConexionBD();
    IClientesDAO clientesDAO=new ClientesDAO(conexionBD);
     Clientes cliente = new Clientes();
        cliente.setNombre("Juan");
        cliente.setApellidoPaterno("Pérez");
        cliente.setApellidoMaterno("Gómez");
        cliente.setFechaNacimiento(LocalDateTime.of(1990, 5, 20, 0, 0)); 
          Ciudad ciudad = new Ciudad("Obregón");
        cliente.setCorreo("juan.perez@example.com");
        cliente.setContraseña("contrasena123"); 
           try {
            clientesDAO.guardar(cliente, ciudad);
            System.out.println("Cliente guardado correctamente.");
        } catch (PersistenciaException e) {
            System.out.println("Error al guardar el cliente: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
}
}}