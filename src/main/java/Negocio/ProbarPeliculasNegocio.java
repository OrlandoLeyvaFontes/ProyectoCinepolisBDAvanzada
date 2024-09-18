/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Persistencia.ConexionBD;
import Persistencia.IConexionBD;
import Persistencia.IPeliculasDAO;
import Persistencia.PeliculasDAO;
import Persistencia.PersistenciaException;
import dtoCinepolis.PeliculasDTO;

/**
 *
 * @author Oley
 */
public class ProbarPeliculasNegocio {

    public static void main(String[] args) {
    IConexionBD conexionBD = new ConexionBD();
        IPeliculasDAO peliculasDAO = new PeliculasDAO(conexionBD);
        PeliculasNegocio peliculasNegocio = new PeliculasNegocio(peliculasDAO);

        PeliculasDTO peliculaDTO = new PeliculasDTO("ALIEN", "adultos", "accion", 180, "estados unidos", "los aliens llegaron ya");
       

       

        try {
            peliculasNegocio.guardar(peliculaDTO);
            System.out.println("Película guardada");
        } catch (PersistenciaException e) {
            e.printStackTrace();
            System.out.println("Error  " + e.getMessage());
        }
    }
}
