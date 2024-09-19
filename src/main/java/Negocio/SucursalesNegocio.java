/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidad.Sucursales;
import Persistencia.PersistenciaException;
import dtoCinepolis.SucursalesDTO;
import Persistencia.ISucursalDAO;

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
        sucursalDAO.guardar(sucursal);
    }

    private Sucursales DTOEntidad(SucursalesDTO sucursalesDTO) {
        Sucursales sucursal = new Sucursales();
        sucursal.setNombre(sucursalesDTO.getNombre());
        sucursal.setCiudad(sucursalesDTO.getCiudad());
        return sucursal;
    }
}
