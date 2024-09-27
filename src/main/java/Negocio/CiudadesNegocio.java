/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidad.Ciudad;
import Persistencia.ICiudadesDAO;
import dtoCinepolis.CiudadesDTO;
import dtoCinepolis.CuidadFiltroTablaDTO;
import dtoCinepolis.CuidadTablaDTO;
import java.util.List;
import Persistencia.PersistenciaException;

/**
 *
 * @author Oley
 */
public class CiudadesNegocio implements ICiudadesNegocio {

    private final ICiudadesDAO ciudadesDAO;

    public CiudadesNegocio(ICiudadesDAO ciudadesDAO) {
        this.ciudadesDAO = ciudadesDAO;
    }

    @Override
    public CiudadesDTO guardar(CiudadesDTO ciudadDTO) throws PersistenciaException {
        Ciudad ciudad = convertirADominio(ciudadDTO);
        Ciudad ciudadGuardada = this.ciudadesDAO.guardar(ciudad);
        return convertirCuidadDTO(ciudadGuardada);

    }

    private Ciudad convertirADominio(CiudadesDTO ciudadesDTO) {
        Ciudad ciudad = new Ciudad();
        ciudad.setNombre(ciudadesDTO.getNombre());
        ciudad.setEstaEliminado(ciudadesDTO.isEstaEliminado());
        return ciudad;
    }

    private CiudadesDTO convertirCuidadDTO(Ciudad cuidad) {
        CiudadesDTO cuidadDTO = new CiudadesDTO();
        cuidadDTO.setNombre(cuidad.getNombre());
        return cuidadDTO;
    }

    @Override
    public List<CuidadTablaDTO> buscarCuidadTabla(CuidadFiltroTablaDTO filtro) throws NegocioException {
        try {
            List<CuidadTablaDTO> cuidadLista = ciudadesDAO.buscarCuidadTabla(filtro);
            if (cuidadLista == null) {
                throw new NegocioException("No se encontraron registros con los filtros");

            }
            return cuidadLista;
        } catch (PersistenciaException e) {
            System.out.println(e.getMessage());
            throw new NegocioException(e.getMessage());
        }
    }

    private CiudadesDTO convertirCiudadDTO(Ciudad ciudad) {
        CiudadesDTO ciudadDTO = new CiudadesDTO();
        ciudadDTO.setId(ciudad.getId());
        ciudadDTO.setNombre(ciudad.getNombre());
        return ciudadDTO;

    }

    private CiudadesDTO convertirACuidadesDTO(Ciudad ciudad) {
        return new CiudadesDTO(
                ciudad.getId(),
                ciudad.getNombre()
        );
    }

    @Override
    public void editar(CiudadesDTO ciudadesDTO) throws NegocioException {
        try {
            Ciudad ciudad = DTOaENTIDAD2(ciudadesDTO);
            ciudadesDAO.editar(ciudad);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al editar la ciudad: " + ex.getMessage(), ex);
        }

    }

    private Ciudad DTOaENTIDAD2(CiudadesDTO ciudadesDTO) {
        Ciudad ciudad = new Ciudad();
        ciudad.setId(ciudadesDTO.getId());
        ciudad.setNombre(ciudadesDTO.getNombre());
        return ciudad;
    }

    private Ciudad DTOaENTIDAD(CiudadesDTO ciudadesDTO) {
        Ciudad ciudad = new Ciudad();
        ciudad.setNombre(ciudadesDTO.getNombre());
        return ciudad;
    }

    @Override
    public CiudadesDTO eliminar(int id) throws NegocioException {
        try {
            if (id <= 0) {
                throw new NegocioException("El id recibido es incorrecto");
            }
            Ciudad ciudad = ciudadesDAO.buscarPorID(id);
            if (ciudad == null) {
                throw new NegocioException("Nose pudo obtener la ciudad con la clave ingresada");
            }
            Ciudad ciudadEliminada = ciudadesDAO.eliminar(id);
            System.out.println(ciudadEliminada);
            return convertirCiudadDTO(ciudadEliminada);

        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }

    }

    @Override
    public CiudadesDTO buscarCiudadPorNombre(String nombreCiudad) throws NegocioException {
        try {
            Ciudad ciudad = ciudadesDAO.buscarCiudadPorNombre(nombreCiudad);

            CiudadesDTO ciudadDTO = new CiudadesDTO();
            ciudadDTO.setId(ciudad.getId());
            ciudadDTO.setNombre(ciudad.getNombre());

            return ciudadDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar la ciudad por nombre en la capa de negocio", e);
        }
    }
}
