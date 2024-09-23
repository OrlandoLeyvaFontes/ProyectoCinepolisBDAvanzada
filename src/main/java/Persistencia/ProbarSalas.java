/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidad.Salas;
import Entidad.Sucursales;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author Oley
 */
public class ProbarSalas {

    public static void main(String[] args) throws PersistenciaException {
         try {
        Salas salas = new Salas();
        salas.setNombre("Sala 1"); // Verifica que esto no sea nulo o vacío
        salas.setCantidadAsientos(35);
        LocalDateTime limpieza = LocalDateTime.now();
        salas.setTiempoLimpieza(limpieza);
        
        Sucursales sucursal = new Sucursales();
        sucursal.setId(4); // Asegúrate de que este ID sea válido
        salas.setSucursales(sucursal);
        
        // Verifica valores
        System.out.println("Nombre: " + salas.getNombre());
        System.out.println("Cantidad de Asientos: " + salas.getCantidadAsientos());
        System.out.println("Tiempo de Limpieza: " + salas.getTiempoLimpieza());
        System.out.println("ID de Sucursal: " + salas.getSucursales().getId());

        // Guardar en la base de datos
        ConexionBD bd = new ConexionBD();
        SalasDAO salasDAO = new SalasDAO(bd);
        salasDAO.guardar(salas);
    } catch (PersistenciaException e) {
        System.err.println("Error: " + e.getMessage());
    } catch (Exception e) {
        System.err.println("Error inesperado: " + e.getMessage());
    }
    }
}
