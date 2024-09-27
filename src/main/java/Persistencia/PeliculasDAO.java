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
<<<<<<< Updated upstream
=======
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
>>>>>>> Stashed changes
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

}
