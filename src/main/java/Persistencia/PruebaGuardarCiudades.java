/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidad.Ciudad;
import dtoCinepolis.CuidadFiltroTablaDTO;
import dtoCinepolis.CuidadTablaDTO;
import java.util.List;

/**
 *
 * @author Oley
 */
public class PruebaGuardarCiudades {

    public static void main(String[] args) throws PersistenciaException {
        try {

            IConexionBD conexionBD = new ConexionBD();
            CiudadesDAO ciudadesDAO = new CiudadesDAO(conexionBD);
//        Ciudad ciudades= new Ciudad("Bolivia");
//        ciudadesDAO.guardar(ciudades);


         
            CuidadFiltroTablaDTO filtro = new CuidadFiltroTablaDTO();
            filtro.setFiltro("guadalajara");
            filtro.setLimit(10);
            filtro.setOffset(0);
            List<CuidadTablaDTO> ciudades = ciudadesDAO.buscarCuidadID(filtro);
            if (ciudades.isEmpty()) {
                System.out.println("No se encontraron ciudades con ese filtro.");
            } else {
                for (CuidadTablaDTO ciudad : ciudades) {
                    System.out.println("ID: " + ciudad.getId() + ", Nombre: " + ciudad.getNombre());
                }
            }
            }catch (PersistenciaException e) {
            System.err.println("Error al buscar ciudades: " + e.getMessage());
            e.printStackTrace();
        }
        }
    }

