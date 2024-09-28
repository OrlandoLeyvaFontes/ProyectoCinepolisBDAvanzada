/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidad.Salas;
import Entidad.Sucursales;
import Persistencia.ISalasDAO;
import Persistencia.PersistenciaException;
import Persistencia.SalasDAO;
import dtoCinepolis.SalaFiltroTablaDTO;
import dtoCinepolis.SalasDTO;
import dtoCinepolis.SalasFiltroTablaDTO;
import dtoCinepolis.SalasTablaDTO;
import dtoCinepolis.SucursalesDTO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oley
 */
public class SalasNegocios implements ISalasNegocios {

    private final ISalasDAO salasDAO;
    private final ISucursalesNegocio sucursalesNegocio;

    public SalasNegocios(ISalasDAO salasDAO, ISucursalesNegocio SucursalesNegocio) {
        this.salasDAO = salasDAO;
        this.sucursalesNegocio = SucursalesNegocio;
    }

    @Override
    public void guardarSucursalesConSalas(SalasDTO salasDTO, String nombre) throws NegocioException {
        try {
            String nombreNormalizado = nombre.trim().toLowerCase();
            SucursalesDTO sucursalesDTO1 = sucursalesNegocio.buscarSucursalPorNombre(nombreNormalizado);
            if (sucursalesDTO1 == null) {
                throw new NegocioException("Sucursal no encontrada: " + nombre);
            }
            salasDTO.setSucursales(sucursalesDTO1);
            Salas salas = convertirADTO(salasDTO);
            salasDAO.guardar(salas);

        } catch (PersistenciaException e) {
            throw new NegocioException("Error al guardar la sala en la capa de negocio", e);
        }
    }

    private Salas convertirADTO(SalasDTO salasDTO) {
        if (salasDTO == null) {
            return null;
        }
        Salas salas = new Salas();
        salas.setId(salasDTO.getId());
        salas.setNombre(salasDTO.getNombre());
        salas.setCantidadAsientos(salasDTO.getCantidadAsientos());
        salas.setTiempoLimpieza(salasDTO.getTiempoLimpieza());
        salas.setSucursales(convertirADTO(salasDTO.getSucursales()));
        salas.setCostoSugerido(salasDTO.getCostoSugerido());
        return salas;
    }

    private Sucursales convertirADTO(SucursalesDTO sucursalesDTO) {
        if (sucursalesDTO == null) {
            return null;
        }
        Sucursales sucursales = new Sucursales();
        sucursales.setId(sucursalesDTO.getId());
        sucursales.setNombreCiudad(sucursalesDTO.getNombreCiudad());
        return sucursales;
    }

    @Override
    public void editar(SalasDTO salasDTO) throws NegocioException {
        try {
            Salas salas = convertirADTO(salasDTO);
            salasDAO.editar(salas);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al editar la sala: " + ex.getMessage(), ex);

        }

    }

    @Override
    public SalasDTO eliminar(int id) throws NegocioException {
        try {
            if (id <= 0) {
                throw new NegocioException("El id recibido es incorrecto");

            }
            Salas salas = salasDAO.buscarPorID(id);
            if (salas == null) {
                throw new NegocioException("Nose pudo obtener la sala con la clave ingresada");
            }
            Salas salaEliminada = salasDAO.eliminar(id);
            System.out.println(salaEliminada);
            return convertirSalaDTO(salas);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());

        }

    }

    private SalasDTO convertirSalaDTO(Salas salas) {
        SalasDTO salasDTO = new SalasDTO();
        salasDTO.setId(salas.getId());
        salasDTO.setNombre(salas.getNombre());
        return salasDTO;
    }

    @Override
    public SalasDTO buscarCiudadesPorNombre(String nombreSala) throws NegocioException {
        try {
            Salas salas = salasDAO.buscarSalasPorNombre(nombreSala);
            SalasDTO salasDTO = new SalasDTO();
            salasDTO.setId(salas.getId());
            salasDTO.setNombre(salas.getNombre());
            return salasDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar la ciudad por nombre en la capa de negocio", e);

        }
    }

    @Override
    public List<SalasTablaDTO> buscarSalaTabla(SalaFiltroTablaDTO filtro) throws NegocioException {
      if (filtro == null) {
        throw new NegocioException("El filtro recibido es null");
    }

    List<SalasTablaDTO> salasLista = null;  

    try {
        salasLista = salasDAO.buscarSalaTabla(filtro);
    } catch (PersistenciaException ex) {
        Logger.getLogger(SalasNegocios.class.getName()).log(Level.SEVERE, null, ex);
        throw new NegocioException("Error al buscar las salas con el filtro", ex); // Lanza la excepción
    }

    if (salasLista == null || salasLista.isEmpty()) {
        throw new NegocioException("No se encontraron registros con los filtros");
    }

    return salasLista;
    }
    
}
