/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidad.Funciones;
import Persistencia.FuncionesDAO;
import Persistencia.IFuncionesDAO;
import Persistencia.PersistenciaException;
import dtoCinepolis.FuncionesDTO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import dtoCinepolis.FuncionesFiltroTablaDTO;
import dtoCinepolis.FuncionesTablaDTO;

/**
 *
 * @author aleja
 */
public class FuncionesNegocio implements IFuncionesNegocio {

    private final IFuncionesDAO funcionesDAO;

    public FuncionesNegocio(IFuncionesDAO funcionesDAO) {
        this.funcionesDAO = funcionesDAO;
    }

    @Override
    public FuncionesDTO guardar(FuncionesDTO funcionDTO) throws PersistenciaException {
        Funciones funcion = convertirAEntidad(funcionDTO);
        Funciones funcionGuardada = funcionesDAO.guardar(funcion);
        return convertirADTO(funcionGuardada);
    }

    @Override
    public FuncionesDTO eliminar(int id) throws PersistenciaException {
        // Eliminar la función por ID
        Funciones funcionEliminada = funcionesDAO.eliminar(id);
        // Devolver el DTO de la función eliminada
        return convertirADTO(funcionEliminada);
    }

    private Funciones convertirAEntidad(FuncionesDTO dto) {
        // Crear y devolver una nueva entidad Funciones a partir del DTO
        return new Funciones(
                dto.getId(), // Asegúrate de que el ID esté incluido en el DTO
                dto.getNombrePelicula(),
                dto.getHoraInicio(),
                dto.getPrecio(),
                dto.getSala(),
                dto.isEstaEliminado()
        );
    }

    private FuncionesDTO convertirADTO(Funciones funcion) {
        // Crear y devolver un nuevo DTO FuncionesDTO a partir de la entidad
        return new FuncionesDTO(
                funcion.getId(),
                funcion.getNombrePelicula(),
                funcion.getHoraInicio(),
                funcion.getPrecio(),
                funcion.getSala(),
                funcion.isEstaEliminado()
        );
    }

    @Override
    public List<FuncionesTablaDTO> buscarFuncionesTabla(FuncionesFiltroTablaDTO filtro) throws NegocioException {
        List<FuncionesTablaDTO> funcionesLista;
        try {
            funcionesLista = funcionesDAO.buscarFuncionesTabla(filtro);
        } catch (PersistenciaException ex) {
            Logger.getLogger(FuncionesNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al buscar funciones: " + ex.getMessage(), ex); // Lanzar la excepción
        }
        return funcionesLista;
    }

}
