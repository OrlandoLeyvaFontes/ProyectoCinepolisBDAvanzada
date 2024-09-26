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
    public ArrayList<PeliculasDTO> leer() throws PersistenciaException {
        PeliculasDTO peliculaDTO;
        Connection con = null;
        ResultSet rs;
        ArrayList<PeliculasDTO> lista = new ArrayList<>();

        try {
            con = conexionBD.crearConexion();
            String leer = "SELECT * FROM peliculas";
            PreparedStatement ps = con.prepareStatement(leer);
            rs = ps.executeQuery();

            while (rs.next()) {
                peliculaDTO = new PeliculasDTO();
                peliculaDTO.setId(rs.getInt("id"));
                peliculaDTO.setTitulo(rs.getString("titulo")); // Cambiado a minúscula
                peliculaDTO.setClasificacion(rs.getString("clasificacion")); // Cambiado para asignar correctamente
                peliculaDTO.setGenero(rs.getString("genero")); // Añadido
                peliculaDTO.setDuracionMinutos(rs.getInt("duracionMinutos"));
                peliculaDTO.setSinopsis(rs.getString("sinopsis")); // Asegúrate de que el nombre sea correcto
                peliculaDTO.setLinkTrailer(rs.getString("linkTrailer"));
                peliculaDTO.setRutaImagen(rs.getString("rutaImagen"));
                lista.add(peliculaDTO);
            }

            rs.close();
            ps.close();
            con.close(); // Mover fuera del while
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexion: " + e.getMessage());
            e.printStackTrace(); // Añadir traza de error
        }
        return lista;
    }

    @Override
    public void guardar(Peliculas pelicula) throws PersistenciaException {
        String sql = "INSERT INTO Peliculas (titulo, clasificacion, genero, duracionMinutos, sinopsis, paisOrigen, linkTrailer, rutaImagen) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement prepared = conexion.prepareStatement(sql)) {            
            prepared.setString(1, pelicula.getTitulo());
            prepared.setString(2, pelicula.getClasificacion());
            prepared.setString(3, pelicula.getGenero());
            prepared.setInt(4, pelicula.getDuracionMinutos());
            prepared.setString(5, pelicula.getSinopsis());
            prepared.setString(6, pelicula.getPaisOrigen());
            prepared.setString(7, pelicula.getLinkTrailer());
            prepared.setString(8, pelicula.getRutaImagen());
            prepared.executeUpdate();
            JOptionPane.showMessageDialog(null, "Película guardada exitosamente.");
        } catch (SQLException e) {
            // Agregar información sobre el error SQL
            throw new PersistenciaException("Error al guardar la pelicula: " + e.getMessage(), e);
        }
    }

    @Override
    public void actualizar(Peliculas peliculas) throws PersistenciaException {
        String consulta = "UPDATE peliculas SET titulo = ?, clasificacion = ?, genero = ?, duracionMinutos = ?, sinopsis = ?, duracionMinutos = ?, linkTrailer = ?, rutaImagen = ? WHERE id = ?";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement stmt = connection.prepareStatement(consulta)) {
            stmt.setString(1, peliculas.getTitulo());
            stmt.setString(2, peliculas.getClasificacion());
            stmt.setString(3, peliculas.getGenero());
            stmt.setInt(4, peliculas.getDuracionMinutos());
            stmt.setString(5, peliculas.getTitulo());
            stmt.setString(6, peliculas.getPaisOrigen());
            stmt.setString(7, peliculas.getLinkTrailer());
            stmt.setString(8, peliculas.getRutaImagen()); 
            stmt.setInt(9, peliculas.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaException("Error al actualizar la pelicula: " + e.getMessage(), e);
        }
    }

    @Override
    public void elimiar(int id) throws PersistenciaException {
        Connection con = null;
        try {
            con = conexionBD.crearConexion();
            String eliminar = """
                              UPDATE Peliculas SET estaEliminado = ? WHERE id = ?
                              """;

            PreparedStatement st = con.prepareStatement(eliminar);
            st.setBoolean(1, true);
            st.setInt(2, id);
            int resultado = st.executeUpdate();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(PeliculasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
