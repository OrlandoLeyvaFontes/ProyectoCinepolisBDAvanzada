/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidad.Ciudad;
import Entidad.Sucursales;
import Persistencia.ISucursalDAO;
import Persistencia.PersistenciaException;
import Persistencia.SucursalDAO;
import dtoCinepolis.CiudadesDTO;
import dtoCinepolis.SucursalesDTO;

/**
 *
 * @author Oley
 */
public class SucursalesNegocio implements ISucursalesNegocio {

    private final ISucursalDAO sucursalesDAO;
    private final ICiudadesNegocio ciudadesNegocio;

    public SucursalesNegocio(ISucursalDAO sucursalesDAO, ICiudadesNegocio ciudadesNegocio) {
        this.sucursalesDAO = sucursalesDAO;
        this.ciudadesNegocio = ciudadesNegocio;
    }

    public void guardarSucursalConCiudadPorNombre(SucursalesDTO sucursalDTO, String nombreCiudad) throws NegocioException {
        try {
            CiudadesDTO ciudadDTO = ciudadesNegocio.buscarCiudadPorNombre(nombreCiudad);

            Ciudad ciudad = convertirADto(ciudadDTO);
            sucursalDTO.setCiudad(ciudadDTO); // Esto debería seguir siendo CiudadesDTO

            Sucursales sucursal = convertirADto(sucursalDTO);

            sucursalesDAO.guardar(sucursal);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al guardar la sucursal en la capa de negocio", e);
        }
    }

    private Ciudad convertirADto(CiudadesDTO ciudadDTO) {
        if (ciudadDTO == null) {
            return null;
        }
        Ciudad ciudad = new Ciudad();
        ciudad.setId(ciudadDTO.getId());
        ciudad.setNombre(ciudadDTO.getNombre());
        return ciudad;
    }

    private Sucursales convertirADto(SucursalesDTO sucursalDTO) {
        if (sucursalDTO == null) {
            return null;
        }
        Sucursales sucursal = new Sucursales();
        sucursal.setId(sucursalDTO.getId());
        sucursal.setNombre(sucursalDTO.getNombre());
        sucursal.setCiudad(convertirADto(sucursalDTO.getCiudad()));
        return sucursal;
    }

    @Override
    public SucursalesDTO buscarSucursalPorNombre(String nombre) throws NegocioException {
    try {
        Sucursales sucursales = sucursalesDAO.buscarSucursalPorNombre(nombre);
        if (sucursales == null) {
            return null; // O lanzar una excepción específica si prefieres
        }
        SucursalesDTO sucursalesDTO = new SucursalesDTO();
        sucursalesDTO.setId(sucursales.getId());
        sucursalesDTO.setNombre(sucursales.getNombre());
        return sucursalesDTO;
    } catch (PersistenciaException e) {
        throw new NegocioException("Error al buscar la sucursal por nombre en la capa de negocio", e);
        }
    }
    
}
