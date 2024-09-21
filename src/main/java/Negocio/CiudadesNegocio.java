/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidad.Ciudad;
import Negocio.ICiudadesNegocio;
import Persistencia.CiudadesDAO;
import Persistencia.ICiudadesDAO;
import Persistencia.PersistenciaException;
import dtoCinepolis.CiudadesDTO;
import dtoCinepolis.CuidadFiltroTablaDTO;
import dtoCinepolis.CuidadModificadoDTO;
import dtoCinepolis.CuidadTablaDTO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            Ciudad ciudad = DTOaENTIDAD(ciudadesDTO);
            ciudadesDAO.editar(ciudad);
        } catch (PersistenciaException ex) {
            Logger.getLogger(CiudadesNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    

    }

    private Ciudad DTOaENTIDAD(CiudadesDTO ciudadesDTO) {
        Ciudad ciudad = new Ciudad();
        ciudad.setNombre(ciudadesDTO.getNombre());
        return ciudad;
    }
}
