/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidad.Funciones;
import Persistencia.IFuncionesDAO;
import Persistencia.PersistenciaException;
import dtoCinepolis.FuncionesDTO;

/**
 *
 * @author aleja
 */
public class FuncionesNegocio implements IFuncionesNegocio {

    private final IFuncionesDAO funcionesDAO;

    public FuncionesNegocio(IFuncionesDAO funcionesDAO) {
        this.funcionesDAO = funcionesDAO;
    }

    public FuncionesDTO guardar(FuncionesDTO funcionDTO) throws PersistenciaException {
        // Convertir DTO a entidad
        Funciones funcion = convertirAEntidad(funcionDTO);
        // Guardar la entidad en la base de datos
        Funciones funcionGuardada = funcionesDAO.guardar(funcion);
        // Convertir la entidad guardada de nuevo a DTO para devolver
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

}

