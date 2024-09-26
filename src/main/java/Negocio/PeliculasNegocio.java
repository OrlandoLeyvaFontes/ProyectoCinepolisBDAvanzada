package Negocio;

import Entidad.Peliculas;
import Persistencia.IConexionBD;
import Persistencia.PersistenciaException;
import dtoCinepolis.PeliculasDTO;
import Persistencia.IPeliculasDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PeliculasNegocio implements IPeliculasNegocio {

    private ConvertidorPeliculas convertir = new ConvertidorPeliculas();
    private IConexionBD conexionBD;
    private IPeliculasDAO peliculaDAO;

    public PeliculasNegocio(IConexionBD conexionBD, IPeliculasDAO peliculasDAO) {
        this.peliculaDAO = peliculasDAO;
        this.conexionBD = conexionBD;
    }

    @Override
    public void guardar(PeliculasDTO peliculaDTO) throws NegocioException {
        if (peliculaDTO.getRutaImagen() == null || peliculaDTO.getRutaImagen().isEmpty()) {
            throw new NegocioException("La ruta de la imagen no puede estar vacía.");
        }

        try (Connection cn = conexionBD.crearConexion()) {
            cn.setAutoCommit(false);

            Peliculas peliculas = convertir.DTOaEntidad(peliculaDTO);

            if (reglasNegocio(peliculaDTO)) {
                this.peliculaDAO.guardar(peliculas);
                cn.commit();
            } else {
                JOptionPane.showMessageDialog(null, "No cumple con las reglas del Negocio");
            }
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al guardar la pelicula en la base de datos", e);
        } catch (SQLException ex) {
            Logger.getLogger(PeliculasNegocio.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error SQL: " + ex.getMessage());
        }
    }

    @Override
    public ArrayList<PeliculasDTO> leer() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actualizar(PeliculasDTO peliculasDTO) throws NegocioException {
        try (Connection cn = conexionBD.crearConexion()) {
            cn.setAutoCommit(false);
            Peliculas peliculas = convertir.DTOaEntidad(peliculasDTO);

            if (reglasNegocio(peliculasDTO)) {
                this.peliculaDAO.actualizar(peliculas);
                cn.commit();
            } else {
                JOptionPane.showMessageDialog(null, "No cumple con las reglas del Negocio");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PeliculasNegocio.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error SQL: " + ex.getMessage());
        } catch (PersistenciaException ex) {
            Logger.getLogger(PeliculasNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(int id) throws NegocioException {
        try (Connection cn = conexionBD.crearConexion()) {
            cn.setAutoCommit(false);
            this.peliculaDAO.elimiar(id);
            cn.commit();
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al eliminar la pelicula: " + e.getMessage(), e);
        } catch (SQLException ex) {
            Logger.getLogger(PeliculasNegocio.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error SQL: " + ex.getMessage());
        }
    }

    public boolean reglasNegocio(PeliculasDTO e) {
        String titulo = e.getTitulo();
        return !titulo.contains("Panduro");
    }
}
