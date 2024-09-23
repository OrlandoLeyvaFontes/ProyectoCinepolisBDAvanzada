/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidad.Salas;
import Entidad.Sucursales;
import Persistencia.PersistenciaException;
import Persistencia.SalasDAO;
import dtoCinepolis.SalasDTO;
import dtoCinepolis.SucursalesDTO;

/**
 *
 * @author Oley
 */
public class SalasNegocios  implements ISalasNegocios{
private SalasDAO  salasDAO;
private SucursalesNegocio SucursalesNegocio;

    public SalasNegocios(SalasDAO salasDAO, SucursalesNegocio SucursalesNegocio) {
        this.salasDAO = salasDAO;
        this.SucursalesNegocio = SucursalesNegocio;
    }

    @Override
    public void guardarSucursalesConSalas(SalasDTO salasDTO, String nombre) throws NegocioException {
try{
    SucursalesDTO sucursalesDTO1=SucursalesNegocio.buscarSucursalPorNombre(nombre);
    salasDTO.setSucursales(sucursalesDTO1);
    Salas salas=convertirADTO(salasDTO);
    salasDAO.guardar(salas);
    
}catch(PersistenciaException e){
                throw new NegocioException("Error al guardar la sala en la capa de negocio", e);

}
    }
    private Salas convertirADTO(SalasDTO salasDTO){
        if(salasDTO==null){
            return null;
        }
        Salas salas=new Salas();
        salas.setId(salasDTO.getId());
        salas.setNombre(salasDTO.getNombre());
        salas.setCantidadAsientos(salasDTO.getCantidadAsientos());
        salas.setTiempoLimpieza(salasDTO.getTiempoLimpieza());
        salas.setSucursales(convertirADTO(salasDTO.getSucursales()));
        return salas;
    }
    private Sucursales convertirADTO(SucursalesDTO sucursalesDTO){
        if(sucursalesDTO==null){
            return null;
        }
        Sucursales sucursales=new Sucursales();
        sucursales.setId(sucursalesDTO.getId());
        sucursales.setNombre(sucursalesDTO.getNombre());
        return sucursales;
    } 
}
