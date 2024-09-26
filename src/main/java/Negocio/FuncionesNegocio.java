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
        Funciones funcion = convertirAEntidad(funcionDTO);
        Funciones funcionGuardada = funcionesDAO.guardar(funcion);
        return convertirADTO(funcionGuardada);
    }

    @Override
    public FuncionesDTO eliminar(int id) throws PersistenciaException {
        Funciones funcionEliminada = funcionesDAO.eliminar(id);
        return convertirADTO(funcionEliminada);
    }

    @Override
    public FuncionesDTO buscarPorNombre(String nombre) throws PersistenciaException {
        Funciones funcion = funcionesDAO.buscarPorNombre(nombre);
        return convertirADTO(funcion);
    }

    private FuncionesDTO convertirFuncionDTO(Funciones funcion) {
        FuncionesDTO funcionesDTO = new FuncionesDTO();
        funcionesDTO.setNombre(funcion.getNombre());
        return funcionesDTO;
    }

    private Funciones convertirAEntidad(FuncionesDTO dto) {
        return new Funciones(dto.getNombre(), dto.getCosto(), dto.getHoraInicio(), dto.isEstaEliminado());
    }

    private FuncionesDTO convertirADTO(Funciones funcion) {
        return new FuncionesDTO(funcion.getNombre(), funcion.getCosto(), funcion.getHoraInicio(), funcion.isEstaEliminado(), funcion.getSalas());
    }

}
