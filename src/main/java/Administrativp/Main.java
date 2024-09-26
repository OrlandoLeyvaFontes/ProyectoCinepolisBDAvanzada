/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Administrativp;

import Negocio.CiudadesNegocio;
import Negocio.ICiudadesNegocio;
import Negocio.ISalasNegocios;
import Negocio.ISucursalesNegocio;
import Negocio.SalasNegocios;
import Negocio.SucursalesNegocio;
import Persistencia.CiudadesDAO;
import Persistencia.ConexionBD;
import Persistencia.ICiudadesDAO;
import Persistencia.IConexionBD;
import Persistencia.ISalasDAO;
import Persistencia.ISucursalDAO;
import Persistencia.SalasDAO;
import Persistencia.SucursalDAO;

/**
 *
 * @author Oley
 */
public class Main {

    public static void main(String[] args) {
        IConexionBD conexionBD = new ConexionBD();

        ICiudadesDAO ciudadesDAO = new CiudadesDAO(conexionBD);
        ISucursalDAO sucursalesDAO = new SucursalDAO(conexionBD);
        ISalasDAO salasDAO = new SalasDAO(conexionBD);

        ICiudadesNegocio ciudadesNegocio = new CiudadesNegocio(ciudadesDAO);
        ISucursalesNegocio sucursalesNegocio = new SucursalesNegocio(sucursalesDAO, ciudadesNegocio);
        ISalasNegocios salasNegocios = new SalasNegocios(salasDAO, sucursalesNegocio);

        AdministradorCuenta administrador = new AdministradorCuenta(ciudadesNegocio, sucursalesNegocio , salasNegocios);

        administrador.setVisible(true);
    }
}
