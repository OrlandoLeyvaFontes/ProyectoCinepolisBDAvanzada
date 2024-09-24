/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Negocio;

import Entidad.Ciudad;
import Entidad.Clientes;
import Persistencia.ClientesDAO;
import Persistencia.ConexionBD;
import Persistencia.PersistenciaException;
import java.time.LocalDateTime;

/**
 *
 * @author rober
 */
public class pruebainiciarsesion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PersistenciaException {
        ConexionBD conexion = new ConexionBD();
        ClientesDAO cdao = new ClientesDAO(conexion);

//        if (cdao.iniciarSesion("rob123", "1234") == true) {
//            System.out.println("yes");
//        }
//
//        Ciudad ciudad = new Ciudad(1, "obregon", false);
//        Clientes cliente = new Clientes(1, "roberto", "verdugo", "beltran", LocalDateTime.now(), "roberto123", "1234", ciudad);
//        cdao.guardar(cliente, ciudad);
        
    }

}
