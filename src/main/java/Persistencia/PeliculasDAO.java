/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidad.Peliculas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Oley
 */
public class PeliculasDAO implements IPeliculasDAO {

    private final IConexionBD conexionBD;

    public PeliculasDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }


    @Override
    public void guardar(Peliculas pelicula) throws PersistenciaException {
        String sql = "INSERT INTO peliculas (titulo, clasificacion, genero,  paisOrigen, duracionMinutos,sinopsis) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement prepared = conexion.prepareStatement(sql)) {
            prepared.setString(1, pelicula.getTitulo());
            prepared.setString(2, pelicula.getClasificacion());
            prepared.setString(3, pelicula.getGenero());
            prepared.setString(4, pelicula.getPaisOrigen());
            prepared.setInt(5, pelicula.getDuracionMinutos());

            prepared.setString(6, pelicula.getTexto());
            prepared.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaException("Error al guardar la pelicula", e);
        }
    }

}
