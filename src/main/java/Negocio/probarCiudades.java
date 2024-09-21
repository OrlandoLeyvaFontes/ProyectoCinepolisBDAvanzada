/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Persistencia.CiudadesDAO;
import Persistencia.ConexionBD;
import Persistencia.ICiudadesDAO;
import Persistencia.IConexionBD;
import Persistencia.PersistenciaException;
import dtoCinepolis.CiudadesDTO;

/**
 *
 * @author Oley
 */
public class probarCiudades {
    public static void main(String[] args) throws PersistenciaException {
        IConexionBD conexionBD=new ConexionBD();
        ICiudadesDAO ciudadesDAO=new CiudadesDAO(conexionBD);
        CiudadesNegocio ciudadesNegocio=new CiudadesNegocio(ciudadesDAO);
        CiudadesDTO ciudadesDTO=new CiudadesDTO("Sinaloa");
        ciudadesNegocio.guardar(ciudadesDTO);
        
        
        
        
        
        
    }
}
