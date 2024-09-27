/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidad.Peliculas;
import dtoCinepolis.PeliculasDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Oley
 */
public class PeliculasDAO implements IPeliculasDAO {

    private IConexionBD conexionBD;

    public PeliculasDAO(IConexionBD conexionBD) throws SQLException {
        this.conexionBD = conexionBD;
    }

    @Override
    public void guardar(Peliculas pelicula) throws PersistenciaException {
        Connection con = null;
        try {
            con = conexionBD.crearConexion();
            String guardar = "INSERT INTO Peliculas (titulo, clasificacion, genero, duracionMinutos, sinopsis, paisOrigen, linkTrailer) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(guardar);

            st.setString(1, pelicula.getTitulo());
            st.setString(2, pelicula.getClasificacion());
            st.setString(3, pelicula.getGenero());
            st.setInt(4, pelicula.getDuracionMinutos());
            st.setString(5, pelicula.getSinopsis());
            st.setString(6, pelicula.getPaisOrigen());
            st.setString(7, pelicula.getLinkTrailer());            
            
            int resultado = st.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Película editada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró una película con ese ID.");
            }
            
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Película guardada exitosamente.");

        } catch (SQLException e) {
            throw new PersistenciaException("Error al guardar la pelicula: " + e.getMessage(), e);
        }
    }

}
