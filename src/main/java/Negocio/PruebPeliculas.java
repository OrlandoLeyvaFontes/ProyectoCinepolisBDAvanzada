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
import dtoCinepolis.PeliculasFiltroTablaDTO;
import dtoCinepolis.PeliculasTablaDTO;
import java.util.List;

/**
 *
 * @author Oley
 */
public class PruebPeliculas {
    public static void main(String[] args) {
        
          // Paso 1: Instancia del DAO (esto depende de cómo lo implementes, aquí es solo un ejemplo)
          IConexionBD conexionBD=new ConexionBD();
        IPeliculasDAO peliculasDAO = new PeliculasDAO(conexionBD); // Asegúrate de tener una implementación de IPeliculasDAO

        // Paso 2: Instanciar PeliculasNegocio
        IPeliculasNegocio peliculasNegocio = new PeliculasNegocio(peliculasDAO);

        // Paso 3: Probar métodos

//         Ejemplo para guardar una película
//        try {
//            PeliculasDTO nuevaPelicula = new PeliculasDTO();
//            nuevaPelicula.setTitulo("Pelicula de Prueba");
//            nuevaPelicula.setClasificacion("A");
//            nuevaPelicula.setGenero("Acción");
//            nuevaPelicula.setPaisOrigen("USA");
//            nuevaPelicula.setDuracionMinutos(120);
//            nuevaPelicula.setSinopsis("Una sinopsis de prueba");
//            nuevaPelicula.setRutaImagen("/ruta/imagen.jpg");
//            nuevaPelicula.setIdFuncion(1);
//
//            PeliculasDTO peliculaGuardada = peliculasNegocio.guardarPeliculas(nuevaPelicula);
//            System.out.println("Película guardada: " + peliculaGuardada.getTitulo());
//        } catch (PersistenciaException e) {
//            e.printStackTrace();
//        }

//        // Ejemplo para buscar películas por filtro
//        try {
//            PeliculasFiltroTablaDTO filtro = new PeliculasFiltroTablaDTO();
//            filtro.setTitulo("Prueba");
//
//            List<PeliculasTablaDTO> peliculas = peliculasNegocio.buscarPeliculasTabla(filtro);
//            for (PeliculasTablaDTO pelicula : peliculas) {
//                System.out.println("Película encontrada: " + pelicula.getTitulo());
//            }
//        } catch (NegocioException e) {
//            e.printStackTrace();
//        }

//        // Ejemplo para editar una película
//        try {
//            PeliculasDTO peliculaEditada = new PeliculasDTO();
//            peliculaEditada.setTitulo("Batman");
//            peliculaEditada.setClasificacion("B");
//            peliculaEditada.setGenero("Drama");
//            peliculaEditada.setPaisOrigen("UK");
//            peliculaEditada.setDuracionMinutos(130);
//            peliculaEditada.setSinopsis("Una nueva sinopsis de prueba");
//            peliculaEditada.setRutaImagen("/ruta/nueva_imagen.jpg");
//            peliculaEditada.setIdFuncion(2);
//
//            peliculasNegocio.editar(peliculaEditada);
//            System.out.println("Película editada con éxito");
//        } catch (NegocioException e) {
//            e.printStackTrace();
//        }
//
//        // Ejemplo para eliminar una película
        try {
            PeliculasDTO peliculaEliminada = peliculasNegocio.eliminar(1);
            System.out.println("Película eliminada: " + peliculaEliminada.getTitulo());
        } catch (NegocioException e) {
            e.printStackTrace();
        }

        // Ejemplo para buscar película por nombre
//        try {
//            PeliculasDTO peliculaPorNombre = peliculasNegocio.buscarPeliculasPorNombre("Pelicula de Prueba");
//            System.out.println("Película encontrada: " + peliculaPorNombre.getTitulo());
//        } catch (NegocioException e) {
//            e.printStackTrace();
//        }
//    }
        
        
        
        
    }
}
