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

        Ciudad ciudad = new Ciudad(sucursalesDTO.getCiudad());

        sucursalDAO.guardar(sucursal, ciudad);
    
    }

    private Sucursales DTOEntidad(SucursalesDTO sucursalesDTO) {
        Sucursales sucursal = new Sucursales();
        sucursal.setNombre(sucursalesDTO.getNombre());
        sucursal.setCiudad(sucursalesDTO.getCiudad());
        return sucursal;
    }
}
