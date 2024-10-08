package Negocio;

import Entidad.Peliculas;
import Persistencia.IConexionBD;
import Persistencia.PersistenciaException;
import dtoCinepolis.PeliculasDTO;
import Persistencia.IPeliculasDAO;
import dtoCinepolis.PeliculasFiltroTablaDTO;
import dtoCinepolis.PeliculasTablaDTO;
import dtoCinepolis.SucursalesFiltroTablaDTO;
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
        Peliculas peliculas = convertirDTO(peliculasDTO);
        this.peliculasDAO.guardar(peliculas);
        return convertirPeliculasDTO(peliculas);

    }

    private Peliculas convertirDTO(PeliculasDTO peliculasDTO) {
        Peliculas peliculas = new Peliculas();
        peliculas.setId(peliculasDTO.getId());
        peliculas.setTitulo(peliculasDTO.getTitulo());
        peliculas.setClasificacion(peliculasDTO.getClasificacion());
        peliculas.setGenero(peliculasDTO.getGenero());
        peliculas.setPaisOrigen(peliculasDTO.getPaisOrigen());
        peliculas.setDuracionMinutos(peliculasDTO.getDuracionMinutos());
        peliculas.setSinopsis(peliculasDTO.getSinopsis());
        peliculas.setRutaImagen(peliculasDTO.getRutaImagen());
        return peliculas;
    }

    @Override
    public List<PeliculasTablaDTO> buscarPeliculasTabla(PeliculasFiltroTablaDTO filtro) throws NegocioException {
        if (filtro == null) {
            throw new NegocioException("El filtro recibido es null");

        }
        List<PeliculasTablaDTO> peliculaLista = null;
        try {
            peliculaLista = this.peliculasDAO.buscarPelicula(filtro);
        } catch (PersistenciaException ex) {
            Logger.getLogger(SalasNegocios.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al buscar las salas con el filtro", ex);
        }
        if (peliculaLista == null || peliculaLista.isEmpty()) {
            throw new NegocioException("No se encontraron registros con los filtros");

        }
        return peliculaLista;
    }

    @Override
    public void editar(PeliculasDTO peliculasDTO) throws NegocioException {
        try {
            Peliculas peliculas = convertirDTO(peliculasDTO);
            this.peliculasDAO.editar(peliculas);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al editar la pelicula: " + ex.getMessage(), ex);

        }

    }

    @Override
    public PeliculasDTO eliminar(int id) throws NegocioException {
         try {
        if (id <= 0) {
            throw new NegocioException("El ID recibido es incorrecto.");
        }
        
        Peliculas peliculas = peliculasDAO.buscarPorID(id);
        if (peliculas == null) {
            throw new NegocioException("No se pudo obtener la película con la clave ingresada.");
        }

        peliculasDAO.eliminar(id);
        
        return convertirPeliculasDTO(peliculas);
    } catch (PersistenciaException ex) {
        throw new NegocioException("Error al eliminar la película: " + ex.getMessage());
    }
    }

    @Override
    public PeliculasDTO buscarPeliculasPorNombre(String nombrePelicula) throws NegocioException {
        try {
            Peliculas peliculas = this.peliculasDAO.buscarPeliculasPorNombre(nombrePelicula);
            PeliculasDTO peliculasDTO = new PeliculasDTO();
            peliculasDTO.setId(peliculas.getId());
            peliculasDTO.setTitulo(peliculas.getTitulo());
            return peliculasDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar la pelicula por nombre en la capa de negocio", e);

        }

    }

    private PeliculasDTO convertirPeliculasDTO(Peliculas peliculas) {
        PeliculasDTO peliculasDTO = new PeliculasDTO();
        peliculasDTO.setId(peliculas.getId());
        peliculasDTO.setTitulo(peliculas.getTitulo());
        peliculasDTO.setClasificacion(peliculas.getClasificacion());
        peliculasDTO.setGenero(peliculas.getGenero());
        peliculasDTO.setPaisOrigen(peliculas.getPaisOrigen());
        peliculasDTO.setDuracionMinutos(peliculas.getDuracionMinutos());
        peliculasDTO.setSinopsis(peliculas.getSinopsis());
        peliculasDTO.setRutaImagen(peliculas.getRutaImagen());
        return peliculasDTO;

    }

    @Override
    public PeliculasDTO buscarPeliculasPorID(int id) throws NegocioException {
try{
    Peliculas peliculas= peliculasDAO.buscarPorID(id);
    if(peliculas==null){
                    throw new NegocioException("No se encontró la pelicula con el ID proporcionado.");

    }
    return convertirPeliculasDTO(peliculas);
}catch(PersistenciaException e){
            throw new NegocioException("Error al buscar la pelicula por ID en la capa de negocio", e);

}}

}
