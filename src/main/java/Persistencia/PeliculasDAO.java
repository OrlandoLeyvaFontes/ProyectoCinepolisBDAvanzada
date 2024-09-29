/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidad.Peliculas;
import dtoCinepolis.PeliculasDTO;
import dtoCinepolis.PeliculasFiltroTablaDTO;
import dtoCinepolis.PeliculasTablaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Oley
 */
public class PeliculasDAO implements IPeliculasDAO {

    private IConexionBD conexionBD;

    public PeliculasDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
     public Peliculas guardar(Peliculas peliculas) throws PersistenciaException {
    String SQInsertarPeliculas = "INSERT INTO pelicula(titulo, clasificacion, genero, paisOrigen, duracionMinutos, sinopsis, rutaImagen) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try (Connection conexion = conexionBD.crearConexion(); 
         PreparedStatement prepa = conexion.prepareStatement(SQInsertarPeliculas, Statement.RETURN_GENERATED_KEYS)) {
         
        prepa.setString(1, peliculas.getTitulo());
        prepa.setString(2, peliculas.getClasificacion());
        prepa.setString(3, peliculas.getGenero());
        prepa.setString(4, peliculas.getPaisOrigen());
        prepa.setInt(5, peliculas.getDuracionMinutos());
        prepa.setString(6, peliculas.getSinopsis());
        prepa.setString(7, peliculas.getRutaImagen());
        
        int rowsAffecred = prepa.executeUpdate();
        
        if (rowsAffecred > 0) {
            try (ResultSet generatedKeys = prepa.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idGenerado = generatedKeys.getInt(1);
                    peliculas.setId(idGenerado);
                }
            }
            System.out.println("Película guardada correctamente con ID: " + peliculas.getId());
        } else {
            System.out.println("No se guardó ninguna película.");
        }
    } catch (SQLException e) {
        throw new PersistenciaException("Error al guardar la película", e);
    }
    return peliculas; 
    }

    @Override
    public List<PeliculasTablaDTO> buscarPelicula(PeliculasFiltroTablaDTO filtro) throws PersistenciaException {
       List<PeliculasTablaDTO> peliculasLista = new ArrayList<>();
    String sql = """
        SELECT id,titulo, clasificacion, genero, paisOrigen, duracionMinutos, sinopsis, rutaImagen
        FROM pelicula
        WHERE titulo LIKE ?
        LIMIT ?
        OFFSET ?
        """;

    try (Connection conexion = conexionBD.crearConexion(); PreparedStatement prepa = conexion.prepareStatement(sql)) {
        prepa.setString(1, "%" + filtro.getFiltro() + "%");
        prepa.setInt(2, filtro.getLimit());
        prepa.setInt(3, filtro.getOffset());

        try (ResultSet resultado = prepa.executeQuery()) {
            while (resultado.next()) {
                PeliculasTablaDTO peliculasTablaDTO = new PeliculasTablaDTO();
                peliculasTablaDTO.setId(resultado.getInt("id"));
                peliculasTablaDTO.setTitulo(resultado.getString("titulo"));
                peliculasTablaDTO.setClasificacion(resultado.getString("clasificacion"));
                peliculasTablaDTO.setGenero(resultado.getString("genero"));
                peliculasTablaDTO.setPaisOrigen(resultado.getString("paisOrigen"));
                peliculasTablaDTO.setDuracionMinutos(resultado.getInt("duracionMinutos"));
                peliculasTablaDTO.setSinopsis(resultado.getString("sinopsis"));
                peliculasTablaDTO.setRutaImagen(resultado.getString("rutaImagen"));
                peliculasLista.add(peliculasTablaDTO);
            }
        }
    } catch (SQLException ex) {
        throw new PersistenciaException("Error al buscar la película", ex);
    }
    return peliculasLista;

    }

    @Override
    public void editar(Peliculas peliculas) throws PersistenciaException {
      String updatePeliculas = """
                          UPDATE pelicula
                          SET titulo=?,
                              clasificacion=?,
                              genero=?,
                              paisOrigen=?,
                              duracionMinutos=?,
                              sinopsis=?,
                              rutaImagen=?
                          WHERE id=?
                          """;
    try (Connection conexion = conexionBD.crearConexion(); 
         PreparedStatement prepa = conexion.prepareStatement(updatePeliculas)) {
        
        
        prepa.setString(1, peliculas.getTitulo());
        prepa.setString(2, peliculas.getClasificacion());
        prepa.setString(3, peliculas.getGenero());
        prepa.setString(4, peliculas.getPaisOrigen());
        prepa.setInt(5, peliculas.getDuracionMinutos());
        prepa.setString(6, peliculas.getSinopsis());
        prepa.setString(7, peliculas.getRutaImagen());
        prepa.setInt(8, peliculas.getId()); 
        
        prepa.executeUpdate();
        
    } catch (SQLException e) {
        throw new PersistenciaException("Error al actualizar la pelicula", e);
    }
    }

    @Override
    public Peliculas buscarPorID(int id) throws PersistenciaException {
        String codigoSQL = """
                        SELECT id, titulo, clasificacion, genero, paisOrigen, duracionMinutos, sinopsis, rutaImagen
                                              FROM pelicula WHERE id=?
                          """;
        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement prepa = conexion.prepareStatement(codigoSQL)) {
            prepa.setInt(1, id);
            try (ResultSet resultSet = prepa.executeQuery()) {
                if (resultSet.next()) {
                    return new Peliculas(resultSet.getString("titulo"));
                } else {
                    System.out.println("No se encontró la pelicula con ID: " + id);
                }
            }

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getErrorCode() + " - " + e.getMessage());
            throw new PersistenciaException("Ocurrió un error al leer la base de datos. Inténtelo de nuevo y si el error persiste, comuníquese con el encargado del sistema.");

        }
        return null;
    }

    @Override
    public Peliculas eliminar(int id) throws PersistenciaException {
       Peliculas peliculas = buscarPorID(id);
    if (peliculas == null) {
        throw new PersistenciaException("Ocurrió un error al obtener la información de la película por su clave.");
    }

    String updatePeliculas = """
        UPDATE pelicula
        SET estaEliminado = 1
        WHERE id = ?;
    """;

    try (Connection connection = this.conexionBD.crearConexion();
         PreparedStatement preparedStatement = connection.prepareStatement(updatePeliculas)) {
        
        preparedStatement.setInt(1, id);
        int filasAfectadas = preparedStatement.executeUpdate();
        System.out.println("Filas afectadas = " + filasAfectadas);
        
        if (filasAfectadas == 0) {
            throw new PersistenciaException("No se pudo eliminar la película.");
        }

        return peliculas;

    } catch (SQLException ex) {
        ex.printStackTrace();
        throw new PersistenciaException("Ocurrió un error al modificar, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
    }

    }

    @Override
    public Peliculas buscarPeliculasPorNombre(String nombrePelicula) throws PersistenciaException {
        String sqlBuscarPelicula = "SELECT * FROM pelicula WHERE titulo=?";
    Peliculas peliculas = null;
    try (Connection conexion = conexionBD.crearConexion(); PreparedStatement prepa = conexion.prepareStatement(sqlBuscarPelicula)) {  
        prepa.setString(1, nombrePelicula);  
        ResultSet resultSet = prepa.executeQuery();
        if (resultSet.next()) {
            peliculas = new Peliculas();
            peliculas.setId(resultSet.getInt("id"));
            peliculas.setTitulo(resultSet.getString("titulo"));
        }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al buscar la sala", e);

        }
        return peliculas;
    }

}
