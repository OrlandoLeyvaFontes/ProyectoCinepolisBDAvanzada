/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidad.Ciudad;
import dtoCinepolis.CiudadesDTO;
import dtoCinepolis.CuidadFiltroTablaDTO;
import dtoCinepolis.CuidadTablaDTO;
import java.util.List;

/**
 *
 * @author Oley
 */
public interface ICiudadesDAO {
    Ciudad guardar(Ciudad ciudad) throws PersistenciaException;
    List< CuidadTablaDTO > buscarCuidadID( CuidadFiltroTablaDTO filtro) throws PersistenciaException;
}
