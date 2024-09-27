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

    private IConexionBD conexionBD;
    private IPeliculasDAO peliculaDAO;
    private Connection cn;

    public PeliculasNegocio(IPeliculasDAO peliculasDAO) {
        this.peliculaDAO = peliculasDAO;
        conexionBD = peliculasDAO.getConexionBD();
    }

    @Override
    public ArrayList<PeliculasDTO> leer() throws NegocioException {
        try {
            return peliculaDAO.leer();
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al leer las peliculas desde la base de datos", e);
        }
    }

    public void guardar(PeliculasDTO peliculaDTO) throws NegocioException {
    Connection cn = null; // Mueve la declaración aquí
    try {
        cn = conexionBD.crearConexion();
        cn.setAutoCommit(false);
        Peliculas pelicula = convertirADTO(peliculaDTO);
        
        if (reglasNegocio(peliculaDTO)) {
            this.peliculaDAO.guardar(pelicula);
            cn.commit();
        } else {
            JOptionPane.showMessageDialog(null, "No cumple con las reglas del Negocio");
            cn.rollback(); // Asegúrate de hacer rollback si no cumple las reglas
        }

    } catch (PersistenciaException e) {
        throw new NegocioException("Error al guardar la pelicula en la base de datos", e);

    } catch (SQLException ex) {
        Logger.getLogger(PeliculasNegocio.class.getName()).log(Level.SEVERE, "SQL Error: " + ex.getMessage(), ex);
        if (cn != null) {
            try {
                cn.rollback(); // Asegúrate de hacer rollback si hay un error
            } catch (SQLException rollbackEx) {
                Logger.getLogger(PeliculasNegocio.class.getName()).log(Level.SEVERE, "Rollback Error: " + rollbackEx.getMessage(), rollbackEx);
            }
        }

    } finally {
        if (cn != null) {
            try {
                cn.close(); // Cierra la conexión al final
            } catch (SQLException closeEx) {
                Logger.getLogger(PeliculasNegocio.class.getName()).log(Level.SEVERE, "Close Connection Error: " + closeEx.getMessage(), closeEx);
            }
        }
    }
}

    @Override
    public void eliminar(int id) throws NegocioException {
        try {
            cn = conexionBD.crearConexion();
            cn.setAutoCommit(false);
            this.peliculaDAO.eliminar(id);
            cn.commit();
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al eliminar el cliente: " + e.getMessage(), e);

        } catch (SQLException ex) {
            Logger.getLogger(PeliculasNegocio.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizar(PeliculasDTO peliculaDTO) throws NegocioException {
        try {
            cn = conexionBD.crearConexion();
            cn.setAutoCommit(false);
            Peliculas pelicula = convertirADTO(peliculaDTO);
            if (reglasNegocio(peliculaDTO)) {
                this.peliculaDAO.actualizar(pelicula);
                cn.commit();
            } else {
                JOptionPane.showMessageDialog(null, "No cumple con las reglas del Negocio");

            }
        } catch (SQLException ex) {
            Logger.getLogger(PeliculasNegocio.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (PersistenciaException ex) {
            Logger.getLogger(PeliculasNegocio.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean reglasNegocio(PeliculasDTO e) {
        String titulo = e.getTitulo();
        return !titulo.contains("Panduro");
    }

    private Peliculas convertirADTO(PeliculasDTO peliculasDTO) {
        if (peliculasDTO == null) {
            return null;
        }
        Peliculas peliculas = new Peliculas();
        peliculas.setId(peliculasDTO.getId());
        peliculas.setTitulo(peliculasDTO.getTitulo());
        peliculas.setClasificacion(peliculasDTO.getClasificacion());
        peliculas.setGenero(peliculasDTO.getGenero());
        peliculas.setPaisOrigen(peliculasDTO.getPaisOrigen());
        peliculas.setDuracionMinutos(peliculasDTO.getDuracionMinutos());
        peliculas.setSinopsis(peliculasDTO.getSinopsis());
        peliculas.setLinkTrailer(peliculasDTO.getLinkTrailer());
        peliculas.setEstaEliminado(peliculasDTO.isEstaEliminado());
        return peliculas;
    }

    public PeliculasDTO convertirEntidad(Peliculas peliculas) {
        PeliculasDTO peliculasDTO = new PeliculasDTO();
        peliculasDTO.setId(peliculas.getId());
        peliculasDTO.setTitulo(peliculas.getTitulo());
        peliculasDTO.setClasificacion(peliculas.getClasificacion());
        peliculasDTO.setGenero(peliculas.getGenero());
        peliculasDTO.setPaisOrigen(peliculas.getPaisOrigen());
        peliculasDTO.setDuracionMinutos(peliculas.getDuracionMinutos());
        peliculasDTO.setSinopsis(peliculas.getSinopsis());
        peliculasDTO.setLinkTrailer(peliculas.getLinkTrailer());
        peliculasDTO.setEstaEliminado(peliculas.isEstaEliminado());
        return peliculasDTO;
    }

}
