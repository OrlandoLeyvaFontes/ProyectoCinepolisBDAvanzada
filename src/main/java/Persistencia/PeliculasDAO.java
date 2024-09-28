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
    public void guardar(Peliculas peliculas) throws PersistenciaException {
        String SQInsertarPeliculas = "INSERT INTO pelicula(titulo,clasificacion,genero,paisOrigen,duracionMinutos,sinopsis,rutaImagen,idFuncion) VALUES(?,?,?,?,?,?,?,?)";
        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement prepa = conexion.prepareStatement(SQInsertarPeliculas)) {
            prepa.setString(1, peliculas.getTitulo());
            prepa.setString(2, peliculas.getClasificacion());
            prepa.setString(3, peliculas.getGenero());
            prepa.setString(4, peliculas.getPaisOrigen());
            prepa.setInt(5, peliculas.getDuracionMinutos());
            prepa.setString(6, peliculas.getSinopsis());
            prepa.setString(7, peliculas.getRutaImagen());
            prepa.setInt(8, peliculas.getIdFuncion());
            int rowsAffecred = prepa.executeUpdate();
            if (rowsAffecred > 0) {
                System.out.println("Sala guardada correctamente.");
            } else {
                System.out.println("No se guardó ninguna sala.");
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al guardar la pelicula", e);

        }
    }

    @Override
    public List<PeliculasTablaDTO> buscarPelicula(PeliculasFiltroTablaDTO filtro) throws PersistenciaException {
        List<PeliculasTablaDTO> peliculasLista = new ArrayList<>();
        String sql = """
             SELECT titulo,clasificacion,genero,paisOrigen,duracionMinutos,sinopsis,rutaImagen,idFuncion
                FROM pelicula
                WHERE nombre LIKE ?
                LIMIT ?
                OFFSET ?
                """;

        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement prepa = conexion.prepareStatement(sql)) {
            prepa.setString(1, "%" + filtro.getFiltro() + "%");
            prepa.setInt(2, filtro.getLimit());
            prepa.setInt(3, filtro.getOffset());

            
            try(ResultSet resultado= prepa.executeQuery()){
             while(resultado.next()){
                 PeliculasTablaDTO peliculasTablaDTO=new PeliculasTablaDTO();
                 peliculasTablaDTO.setTitulo(resultado.getString("titulo"));   peliculasTablaDTO.setClasificacion(resultado.getString("clasificacion"));
                 peliculasTablaDTO.setGenero(resultado.getString("genero"));   peliculasTablaDTO.setPaisOrigen(resultado.getString("paisOrigen"));
                 peliculasTablaDTO.setDuracionMinutos(resultado.getInt("duracionMinutos")); peliculasTablaDTO.setSinopsis(resultado.getString("sinopsis"));
                 peliculasTablaDTO.setRutaImagen("rutaImagen");  peliculasTablaDTO.setIdFuncion(resultado.getInt("idFuncion"));
                 peliculasLista.add(peliculasTablaDTO);
             }
            }  
            //duracionMinutos,sinopsis,rutaImagen,idFuncion
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al buscar pelicula", ex);

        }
        return peliculasLista;

    }

    @Override
    public void editar(Peliculas peliculas) throws PersistenciaException {
     String updatePeliculas = """
                          UPDATE  pelicula
                          SET titulo=?,
                              clasificacion=?,
                              genero=?,
                              paisOrigen=?,
                              duracionMinutos=?,
                              sinopsis=?,
                              rutaImagen=?,
                              idFuncion=?
                          WHERE id=?
                          """;
    try (Connection conexion = conexionBD.crearConexion(); 
         PreparedStatement prepa = conexion.prepareStatement(updatePeliculas)) {
        
        // Asignar los valores a los parámetros
        prepa.setString(1, peliculas.getTitulo());
        prepa.setString(2, peliculas.getClasificacion());
        prepa.setString(3, peliculas.getGenero());
        prepa.setString(4, peliculas.getPaisOrigen());
        prepa.setInt(5, peliculas.getDuracionMinutos());
        prepa.setString(6, peliculas.getSinopsis());
        prepa.setString(7, peliculas.getRutaImagen());
        prepa.setInt(8, peliculas.getIdFuncion());
        prepa.setInt(9, peliculas.getId());  // Aquí pasamos el ID como noveno parámetro
        
        // Ejecutar la actualización
        prepa.executeUpdate();
        
    } catch (SQLException e) {
        throw new PersistenciaException("Error al actualizar la pelicula", e);
    }
    }

    @Override
    public Peliculas buscarPorID(int id) throws PersistenciaException {
        String codigoSQL = """
                          SELECT titulo
                          FROM pelicula
                          WHERE id=?
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
         try {
        Peliculas peliculas = buscarPorID(id);
        if (peliculas == null) {
            throw new PersistenciaException("Ocurrió un error en obtener la información de la pelicula por su clave");
        }

        Connection connection = this.conexionBD.crearConexion();
        // Actualiza la consulta para establecer el valor de 'estaEliminado'
        String updatePeliculas = """
                               UPDATE pelicula
                               SET estaEliminado = 1  
                               WHERE id = ?;
                               """;

        PreparedStatement preparedStatement = connection.prepareStatement(updatePeliculas);
        preparedStatement.setInt(1, id);
        int filasAfectadas = preparedStatement.executeUpdate();
        System.out.println("filasAfectadas = " + filasAfectadas);
        preparedStatement.close();
        connection.close();
        return peliculas;
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
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
