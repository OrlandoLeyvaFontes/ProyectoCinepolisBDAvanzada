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

    public PeliculasDAO(IConexionBD conexionBD)  {
        this.conexionBD = conexionBD;
    }

    @Override
    public IConexionBD getConexionBD() {
        return conexionBD;
    }

    @Override
    public ArrayList<PeliculasDTO> leer() throws PersistenciaException {
        PeliculasDTO peliculaDTO;
        Connection con = null;
        ResultSet rs;
        ArrayList<PeliculasDTO> lista = new ArrayList<>();

        try {
            con = conexionBD.crearConexion();
            String leer = "SELECT * FROM cinepolis.peliculas;";
            PreparedStatement ps = con.prepareStatement(leer);
            rs = ps.executeQuery();

            while (rs.next()) {
                peliculaDTO = new PeliculasDTO();
                peliculaDTO.setId(rs.getInt("id"));
                peliculaDTO.setTitulo(rs.getString("Titulo"));
                peliculaDTO.setClasificacion(rs.getString("Clasificacion"));
                peliculaDTO.setGenero(rs.getString("Genero"));
                peliculaDTO.setPaisOrigen(rs.getString("PaisOrigen"));
                peliculaDTO.setDuracionMinutos(rs.getInt("DuracionMinutos"));
                peliculaDTO.setSinopsis(rs.getString("Sinopsis"));
                peliculaDTO.setLinkTrailer(rs.getString("LinkTrailer"));
                //peliculaDTO.setRutaImagen(rs.getString("RutaImagen"));
                peliculaDTO.setEstaEliminado(rs.getBoolean("EstaEliminado"));
                lista.add(peliculaDTO);

                rs.close();
                ps.close();
                con.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexion" + e.getMessage());
        }
        return lista;
    }

    @Override
    public void guardar(Peliculas pelicula) throws PersistenciaException {
        Connection con = null;
        try {
            con = conexionBD.crearConexion();
            String guardar = "INSERT INTO Peliculas (titulo, clasificacion, genero,  paisOrigen, duracionMinutos, sinopsis, linkTrailer) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(guardar);

            st.setString(1, pelicula.getTitulo());
            st.setString(2, pelicula.getClasificacion());
            st.setString(3, pelicula.getGenero());
            st.setString(4, pelicula.getPaisOrigen());
            st.setInt(5, pelicula.getDuracionMinutos());
            st.setString(6, pelicula.getSinopsis());
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

    @Override
    public void eliminar(int id) throws PersistenciaException {
        Connection con = null;
        try {
            con = conexionBD.crearConexion();
            String eliminar = """
                              UPDATE Peliculas SET estaEliminado = ? WHERE `id` = ?
                              """;
            PreparedStatement st = con.prepareStatement(eliminar);
            st.setBoolean(1, true);
            st.setInt(2, id);

            int resultado = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se elimino la pelicula.");

            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(PeliculasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void actualizar(Peliculas pelicula) throws PersistenciaException {
        Connection con = null;
        try {
            con = conexionBD.crearConexion();
            String editar = "UPDATE Peliculas SET titulo = ?, clasificacion = ?, genero = ?, paisOrigen = ?, duracionMinutos = ?, sinopsis = ?, linkTrailer = ?"
                    + "WHERE id = ?";
            PreparedStatement st = con.prepareStatement(editar);
            st.setString(1, pelicula.getTitulo());
            st.setString(2, pelicula.getClasificacion());
            st.setString(3, pelicula.getGenero());
            st.setString(4, pelicula.getPaisOrigen());
            st.setInt(5, pelicula.getDuracionMinutos());
            st.setString(6, pelicula.getSinopsis());
            st.setString(7, pelicula.getLinkTrailer());
            st.setInt(8, pelicula.getId());

            int resultado = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se edito la pelicula.");
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(PeliculasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
