/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oley
 */
public class PruebaConexion {

    public static void main(String[] args) {
        try {
            IConexionBD conexionBD = new ConexionBD();
            conexionBD.crearConexion();
            System.out.println("Se creo la conexion");
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
