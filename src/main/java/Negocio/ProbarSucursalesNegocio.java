/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Persistencia.ConexionBD;
import Persistencia.IConexionBD;
import Persistencia.ISucursalDAO;
import Persistencia.PersistenciaException;
import Persistencia.SucursalDAO;
import dtoCinepolis.SucursalesDTO;

/**
 *
 * @author Oley
 */
public class ProbarSucursalesNegocio {
    public static void main(String[] args) throws PersistenciaException {
     IConexionBD conexionBD = new ConexionBD(); 
        ISucursalDAO sucursalDAO = new SucursalDAO(conexionBD);
        SucursalesNegocio sucursalesNegocio = new SucursalesNegocio(sucursalDAO);
        SucursalesDTO sucursaleDTO = new SucursalesDTO("Itcatson", "Sinaloa");
        
        System.out.println("Guardando sucursal: " + sucursaleDTO.getNombre() + ", " + sucursaleDTO.getCiudad());
        
        sucursalesNegocio.guardar(sucursaleDTO);
    }
}
