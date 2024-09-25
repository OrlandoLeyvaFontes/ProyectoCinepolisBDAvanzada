/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author Oley
 */
public class PeliculasNegocio implements IPeliculasNegocio {

    private ConvertidorPeliculas convertir = new ConvertidorPeliculas();
    private IConexionBD conexionBD;
    private Connection cn;
    private IPeliculasDAO peliculaDAO;

    public PeliculasNegocio(IConexionBD conexionBD, IPeliculasDAO peliculasDAO) {
        this.peliculaDAO = peliculasDAO;
        this.conexionBD = conexionBD;
        this.convertir = new ConvertidorPeliculas();
    }

    @Override
    public void guardar(PeliculasDTO peliculaDTO) throws NegocioException {
        try {
            cn = conexionBD.crearConexion();
            cn.setAutoCommit(false);
            Peliculas peliculas = convertir.DTOaEntidad(peliculaDTO);
            if (reglasNegocio(peliculaDTO)) {
                this.peliculaDAO.guardar(peliculas);
                cn.commit();
            } else {
                JOptionPane.showMessageDialog(null, "No cumple con las reglas del Negocio");

            }
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al guardar el cliente en la base de datos", e);

        } catch (SQLException ex) {
            Logger.getLogger(PeliculasNegocio.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<PeliculasDTO> leer() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar(PeliculasDTO peliculasDTO) throws NegocioException {
        try {
            cn = conexionBD.crearConexion();
            cn.setAutoCommit(false);
            Peliculas peliculas = convertir.DTOaEntidad(peliculasDTO);
            if (reglasNegocio(peliculasDTO)) {
                this.peliculaDAO.actualizar(peliculas);
                cn.commit();
            }
            JOptionPane.showMessageDialog(null, "No cumple con las reglas del Negocio");

        } catch (SQLException ex) {
            Logger.getLogger(PeliculasNegocio.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (PersistenciaException ex) {
            Logger.getLogger(PeliculasNegocio.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(int id) throws NegocioException {
        try {
            cn = conexionBD.crearConexion();
            cn.setAutoCommit(false);
            this.peliculaDAO.elimiar(id);
            cn.commit();
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al eliminar el cliente: " + e.getMessage(), e);

        } catch (SQLException ex) {
            Logger.getLogger(PeliculasNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean reglasNegocio(PeliculasDTO e) {
        String titulo = e.getTitulo();
        if (titulo.contains("Panduro")) {
            return false;
        } else {
            return true;
        }
    }

}
