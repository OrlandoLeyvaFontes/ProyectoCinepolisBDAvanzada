/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Persistencia;

/**
 *
 * @author rober
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PersistenciaException {
        IConexionBD conexionBD = new ConexionBD();
        String correo1 = "rob123";
        String contrasena1 = "1234";
        ClientesDAO c = new ClientesDAO(conexionBD);

        boolean valido = c.iniciarSesion(correo1, contrasena1);

        if (valido = true) {
            System.out.println("yes");
        }
    }

}
