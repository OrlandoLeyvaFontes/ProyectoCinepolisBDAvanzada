/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Administrativp;

import Negocio.CiudadesNegocio;
import Negocio.ICiudadesNegocio;
import Persistencia.CiudadesDAO;
import Persistencia.ConexionBD;
import Persistencia.ICiudadesDAO;
import Persistencia.IConexionBD;

/**
 *
 * @author Oley
 */
public class Main {
    public static void main(String[] args) {
        IConexionBD conexionBD=new ConexionBD();
        ICiudadesDAO ciudadesDAO=new CiudadesDAO(conexionBD);
        ICiudadesNegocio ciudadesNegocio=new CiudadesNegocio(ciudadesDAO);
        AdministradorCuenta amdministrador=new AdministradorCuenta();
        amdministrador.setVisible(true);
    }
}
