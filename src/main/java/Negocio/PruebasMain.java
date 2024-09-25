/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Persistencia.CiudadesDAO;
import Persistencia.ConexionBD;
import Persistencia.SalasDAO;
import Persistencia.SucursalDAO;
import dtoCinepolis.SalasDTO;
import dtoCinepolis.SucursalesDTO;
import java.time.LocalDateTime;

/**
 *
 * @author Oley
 */
public class PruebasMain {
    public static void main(String[] args) {
     try {
    ConexionBD conexionBD = new ConexionBD();
    SucursalDAO sucursalesDAO = new SucursalDAO(conexionBD);
    SalasDAO salasDAO = new SalasDAO(conexionBD);
    CiudadesDAO ciudadesDAO = new CiudadesDAO(conexionBD);
    CiudadesNegocio ciudadesNegocio = new CiudadesNegocio(ciudadesDAO);
    SucursalesNegocio sucursalesNegocio = new SucursalesNegocio(sucursalesDAO, ciudadesNegocio);
    SalasNegocios salasNegocios = new SalasNegocios(salasDAO, sucursalesNegocio);

    SalasDTO salasDTO = new SalasDTO();
    salasDTO.setNombre("Sala 111");
    salasDTO.setCantidadAsientos(50);
    LocalDateTime tiempoLimpieza = LocalDateTime.now(); 
    salasDTO.setTiempoLimpieza(tiempoLimpieza);
    salasDTO.setCostoSugerido(667.7);
    String nombreSucursal = "Soriana";  
    System.out.println("Buscando sucursal con nombre: " + nombreSucursal);
    
    SucursalesDTO sucursalesDTO1 = sucursalesNegocio.buscarSucursalPorNombre(nombreSucursal);
    
    if (sucursalesDTO1 == null || sucursalesDTO1.getId() == 0) {
        throw new NegocioException("Sucursal no encontrada o ID no válido");
    }
    
    System.out.println("ID de la sucursal encontrado: " + sucursalesDTO1.getId());
    salasDTO.setSucursales(sucursalesDTO1);

    System.out.println("Datos de la sala: " + salasDTO);
    salasNegocios.guardarSucursalesConSalas(salasDTO, nombreSucursal);
    System.out.println("Sala guardada exitosamente.");
} catch (NegocioException e) {
    System.err.println("Error al guardar la sala: " + e.getMessage());
    e.printStackTrace();
}
        
    }
}
