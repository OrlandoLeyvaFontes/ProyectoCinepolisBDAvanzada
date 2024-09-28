/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Administrativp;

import Negocio.CiudadesNegocio;
import Negocio.ICiudadesNegocio;
import Negocio.FuncionesNegocio;
import Negocio.IFuncionesNegocio;
import Negocio.IPeliculasNegocio;
import Negocio.ISalasNegocios;
import Negocio.ISucursalesNegocio;
import Negocio.PeliculasNegocio;
import Negocio.SalasNegocios;
import Negocio.SucursalesNegocio;
import Persistencia.CiudadesDAO;
import Persistencia.ConexionBD;
import Persistencia.ICiudadesDAO;
import Persistencia.IConexionBD;
import Persistencia.IPeliculasDAO;
import Persistencia.ISalasDAO;
import Persistencia.ISucursalDAO;
import Persistencia.PeliculasDAO;
import Persistencia.SalasDAO;
import Persistencia.SucursalDAO;
import Persistencia.FuncionesDAO;
import Persistencia.IFuncionesDAO;
import java.sql.SQLException;

/**
 *
 * @author Oley
 */
public class Main {

    public static void main(String[] args)  {
        IConexionBD conexionBD = new ConexionBD();

        ICiudadesDAO ciudadesDAO = new CiudadesDAO(conexionBD);
        ISucursalDAO sucursalesDAO = new SucursalDAO(conexionBD);
        ISalasDAO salasDAO = new SalasDAO(conexionBD);
        IPeliculasDAO peliculasDAO = new PeliculasDAO(conexionBD);
        ICiudadesNegocio ciudadesNegocio = new CiudadesNegocio(ciudadesDAO);
        ISucursalesNegocio sucursalesNegocio = new SucursalesNegocio(sucursalesDAO, ciudadesNegocio);
        ISalasNegocios salasNegocios = new SalasNegocios(salasDAO, sucursalesNegocio);
//        IPeliculasNegocio peliculasNegocio = new PeliculasNegocio(peliculasDAO);
        IFuncionesDAO funcionesDAO = new FuncionesDAO(conexionBD);
        IFuncionesNegocio funcionesNegocio = new FuncionesNegocio(funcionesDAO);
       AdministradorCuenta administradorCuenta=new AdministradorCuenta(ciudadesNegocio, sucursalesNegocio, salasNegocios, funcionesNegocio);
//        AdministradorCuenta administrador = new AdministradorCuenta(ciudadesNegocio, sucursalesNegocio, salasNegocios,peliculasNegocio, funcionesNegocio);
        administradorCuenta.setVisible(true);
   
}
}
