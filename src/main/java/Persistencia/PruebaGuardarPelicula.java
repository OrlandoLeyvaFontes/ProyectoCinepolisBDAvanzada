/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidad.Peliculas;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oley
 */
public class PruebaGuardarPelicula {

    public static void main(String[] args) throws PersistenciaException {
        IConexionBD conexionBD = new ConexionBD();
        PeliculasDAO peliculasDAO = new PeliculasDAO(conexionBD);
        Peliculas peliculas = new Peliculas("Mi villano favorito 12", "niños", "comedia", 180, "estados unidos", "cuarta parte de la pelicula de mi villano favorito","https://www.youtube.com/watch?v=I0_qFoptZ4Y");
        try {
            peliculasDAO.guardar(peliculas);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PruebaGuardarPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
}
