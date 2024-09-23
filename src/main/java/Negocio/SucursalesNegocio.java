/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidad.Ciudad;
import Entidad.Sucursales;
import Persistencia.PersistenciaException;
import dtoCinepolis.SucursalesDTO;
import Persistencia.ISucursalDAO;
import Persistencia.SucursalDAO;
import dtoCinepolis.CiudadesDTO;

/**
 *
 * @author Oley
 */
public class SucursalesNegocio implements ISucursalesNegocio {

    private final ISucursalDAO sucursalDAO;
    SucursalesDTO sucursalDTO;

    public SucursalesNegocio(ISucursalDAO sucursalDAO) {
        this.sucursalDAO = sucursalDAO;
    }

    @Override
    public void guardar(SucursalesDTO sucursalesDTO) throws PersistenciaException {
        Sucursales sucursal = DTOEntidad(sucursalesDTO);
    
    if (sucursal.getCiudad() == null || sucursal.getCiudad().getId() <= 0) {
        throw new PersistenciaException("La ciudad asociada no es válida.");
    }

    sucursalDAO.guardar(sucursal);
    
    }

     private Sucursales DTOEntidad(SucursalesDTO sucursalesDTO) {
         Sucursales sucursal = new Sucursales();
    sucursal.setNombre(sucursalesDTO.getNombre());
    Ciudad ciudad = DTOCiudad(sucursalesDTO.getCiudad());
    sucursal.setCiudad(ciudad);

    return sucursal;
    }

    private Ciudad DTOCiudad(CiudadesDTO ciudadDTO) {
    if (ciudadDTO == null) {
        return null; // Manejar el caso donde no haya ciudad asociada
    }
    Ciudad ciudad = new Ciudad();
    ciudad.setId(ciudadDTO.getId());
    ciudad.setNombre(ciudadDTO.getNombre());
    return ciudad;
    }
}
