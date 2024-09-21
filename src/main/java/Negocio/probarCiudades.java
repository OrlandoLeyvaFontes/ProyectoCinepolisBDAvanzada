/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidad.Ciudad;
import Persistencia.CiudadesDAO;
import Persistencia.ConexionBD;
import Persistencia.ICiudadesDAO;
import Persistencia.IConexionBD;
import Persistencia.PersistenciaException;
import dtoCinepolis.CiudadesDTO;
import dtoCinepolis.CuidadFiltroTablaDTO;
import dtoCinepolis.CuidadTablaDTO;
import java.util.List;
import Negocio.ICiudadesNegocio;
import dtoCinepolis.CuidadModificadoDTO;

/**
 *
 * @author Oley
 */
public class probarCiudades {
    public static void main(String[] args) throws PersistenciaException, NegocioException {
//        IConexionBD conexionBD=new ConexionBD();
//        ICiudadesDAO ciudadesDAO=new CiudadesDAO(conexionBD);
//        CiudadesNegocio ciudadesNegocio=new CiudadesNegocio(ciudadesDAO);
//        CiudadesDTO ciudadesDTO=new CiudadesDTO("Sinaloa");
//        ciudadesNegocio.guardar(ciudadesDTO);
//ICiudadesDAO ciudadesDAO = new CiudadesDAO(new ConexionBD());
//ICiudadesNegocio ciudadesNegocio = new CiudadesNegocio(ciudadesDAO);
//CuidadFiltroTablaDTO filtro = new CuidadFiltroTablaDTO();
//filtro.setFiltro("obregon");
//filtro.setLimit(10);
//filtro.setOffset(0);
//List<CuidadTablaDTO> ciudades = ciudadesNegocio.buscarCuidadTabla(filtro);
//if (ciudades != null && !ciudades.isEmpty()) {
//    for (CuidadTablaDTO ciudad : ciudades) {
//        System.out.println("ID: " + ciudad.getId() + ", Nombre: " + ciudad.getNombre());
//    }
//} else {
//    System.out.println("No se encontraron ciudades con ese filtro.");
//}
      
          IConexionBD conexionBD = new ConexionBD();
        ICiudadesDAO ciudadesDAO = new CiudadesDAO(conexionBD);
        CiudadesNegocio ciudadesNegocio = new CiudadesNegocio(ciudadesDAO);

        CiudadesDTO ciudadesDTO = new CiudadesDTO();
        ciudadesDTO.setId(10);
        ciudadesDTO.setNombre("Nuevo Nombre");

        try {
            ciudadesNegocio.editar(ciudadesDTO);
            System.out.println("Ciudad actualizada correctamente.");
        } catch (NegocioException e) {
            System.err.println("Error al actualizar la ciudad: " + e.getMessage());
        }
        
    }
}
