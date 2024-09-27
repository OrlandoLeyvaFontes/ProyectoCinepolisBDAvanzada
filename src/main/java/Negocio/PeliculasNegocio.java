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

    public PeliculasNegocio(IConexionBD conexionBD, IPeliculasDAO peliculasDAO) {
        this.peliculaDAO = peliculasDAO;
        this.conexionBD = conexionBD;
    }

    @Override
    public void guardar(PeliculasDTO peliculaDTO) throws NegocioException {

    }


    public boolean reglasNegocio(PeliculasDTO e) {
        String titulo = e.getTitulo();
        return !titulo.contains("Panduro");
    }
    
    private Peliculas convertirADTO(PeliculasDTO peliculasDTO){
        if (peliculasDTO == null) {
            return null;
        }
        Peliculas peliculas = new Peliculas();
        peliculas.setId(peliculasDTO.getId());
    }
    
    
//    private Clientes convertirADTO(ClientesDTO clientesDTO) {
//        if (clientesDTO == null) {
//            return null;
//        }
//        Clientes clientes = new Clientes();
//        clientes.setId(clientesDTO.getId());
//        clientes.setNombre(clientesDTO.getNombre());
//        clientes.setApellidoPaterno(clientesDTO.getApellidoPaterno());
//        clientes.setApellidoMaterno(clientesDTO.getApellidoMaterno());
//        clientes.setFechaNacimiento(clientesDTO.getFechaNacimiento());
//        clientes.setCorreo(clientesDTO.getCorreo());
//        clientes.setContraseña(clientesDTO.getContraseña());
//        clientes.setCiudad(convertirADTO(clientesDTO.getCiudad()));
//        return clientes;
//
//    }
//
//    private Ciudad convertirADTO(CiudadesDTO ciudadesDTO) {
//        if (ciudadesDTO == null) {
//            return null;
//        }
//        Ciudad ciudad = new Ciudad();
//        ciudad.setId(ciudadesDTO.getId());
//        ciudad.setNombre(ciudadesDTO.getNombre());
//        return ciudad;
//
//    }
}
