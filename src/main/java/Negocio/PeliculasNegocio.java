package Negocio;

import Entidad.Peliculas;
import Persistencia.IConexionBD;
import Persistencia.PersistenciaException;
import dtoCinepolis.PeliculasDTO;
import Persistencia.IPeliculasDAO;
import dtoCinepolis.PeliculasFiltroTablaDTO;
import dtoCinepolis.PeliculasTablaDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PeliculasNegocio implements IPeliculasNegocio {

    private final IPeliculasDAO peliculasDAO;

    public PeliculasNegocio(IPeliculasDAO peliculasDAO) {
        this.peliculasDAO = peliculasDAO;
    }

    @Override
    public PeliculasDTO guardarPeliculas(PeliculasDTO peliculasDTO) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PeliculasTablaDTO> buscarPeliculasTabla(PeliculasFiltroTablaDTO filtro) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editar(PeliculasDTO peliculasDTO) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PeliculasDTO eliminar(int id) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PeliculasDTO buscarPeliculasPorNombre(String nombrePelicula) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private PeliculasDTO convertirPeliculasDTO(Peliculas peliculas) {
        PeliculasDTO peliculasDTO = new PeliculasDTO();
        peliculasDTO.setTitulo(peliculas.getTitulo());
        peliculasDTO.setClasificacion(peliculas.getClasificacion());
        peliculasDTO.setGenero(peliculas.getGenero());
        peliculasDTO.setPaisOrigen(peliculas.getPaisOrigen());
        peliculasDTO.setDuracionMinutos(peliculas.getDuracionMinutos());
        peliculasDTO.setSinopsis(peliculas.getSinopsis());
        peliculasDTO.setRutaImagen(peliculas.getRutaImagen());
        peliculasDTO.setIdFuncion(peliculas.getIdFuncion());
        return peliculasDTO;

    }

}
