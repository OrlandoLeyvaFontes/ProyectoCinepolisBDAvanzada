/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Negocio.NegocioException;
import Negocio.PeliculasNegocio;
import dtoCinepolis.PeliculasDTO;
import java.sql.SQLException;

/**
 *
 * @author rober
 */
public class probarPeliculas {

    public static void main(String[] args) throws SQLException {
        try {
            //PeliculasDTO nuevaPelicula = new PeliculasDTO(1, "Inception", "PG-13", "Ciencia Ficción", 148, "EEUU", "Un ladrón que roba secretos a través del uso de la tecnología de los sueños.", "http://trailer.link", "ruta/a/la/imagen.jpg", false);
            PeliculasDTO nuevaPelicula = new PeliculasDTO(1);
            IConexionBD conexionBD = new ConexionBD();
            IPeliculasDAO peliculasDAO = new PeliculasDAO(conexionBD);
            PeliculasNegocio peliculasNegocio = new PeliculasNegocio(conexionBD, peliculasDAO);
            peliculasNegocio.eliminar(0);

            System.out.println("Película eliminada con éxito");
        } catch (NegocioException e) {
            System.out.println("Error al guardar la película: " + e.getMessage());
        }
    }
}
