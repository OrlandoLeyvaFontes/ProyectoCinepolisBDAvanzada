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

    private final IConexionBD conexionBD;

    public PeliculasDAO(IConexionBD conexionBD) {
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
                peliculaDTO.setTitulo(rs.getString("Titulo"));
                peliculaDTO.setClasificacion(rs.getString("Genero"));
                peliculaDTO.setClasificacion(rs.getString("Clasificacion"));
                peliculaDTO.setDuracionMinutos(rs.getInt("DuracionMinutos"));
                peliculaDTO.setTexto(rs.getString("Texto"));
                peliculaDTO.setLinkTrailer(rs.getString("LinkTrailer"));
                peliculaDTO.setRutaImagen(rs.getString("RutaImagen"));
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
        String sql = "INSERT INTO peliculas (titulo, clasificacion, genero,  paisOrigen, duracionMinutos,sinopsis,linkTrailer) VALUES (?, ?, ?, ?, ?, ?,?)";
        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement prepared = conexion.prepareStatement(sql)) {
            prepared.setString(1, pelicula.getTitulo());
            prepared.setString(2, pelicula.getClasificacion());
            prepared.setString(3, pelicula.getGenero());
            prepared.setString(4, pelicula.getPaisOrigen());
            prepared.setInt(5, pelicula.getDuracionMinutos());

            prepared.setString(6, pelicula.getTexto());
            prepared.setString(7, pelicula.getLinkTrailer());
            prepared.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaException("Error al guardar la pelicula", e);
        }
    }

    @Override
    public void actualizar(Peliculas peliculas) throws PersistenciaException {
        String consulta = "UPDATE peliculas SET id = ?, titulo = ?, clasificacion = ?, genero = ?, paisOrigen = ?, duracionMinutos = ?, sinopsis = ?, linkTrailer = ?, rutaImegen = ? "
                + "WHERE id = ?";
        
        try (Connection connection = conexionBD.crearConexion(); PreparedStatement stmt = connection.prepareStatement(consulta)){
            stmt.setString(1, peliculas.getTitulo());
            stmt.setString(2, peliculas.getClasificacion());
            stmt.setString(3, peliculas.getGenero());
            stmt.setString(4, peliculas.getPaisOrigen());
            stmt.setInt(5, peliculas.getDuracionMinutos());
            stmt.setString(6, peliculas.getTexto());
            stmt.setString(7, peliculas.getLinkTrailer());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            throw new PersistenciaException("Error al actualizar el cliente", e);
        }
    }

    @Override
    public void elimiar(int id) throws PersistenciaException {
        Connection con =  null;
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
