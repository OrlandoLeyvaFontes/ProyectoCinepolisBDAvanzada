/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidad.Salas;
import dtoCinepolis.SalaFiltroTablaDTO;
import dtoCinepolis.SalasTablaDTO;
import java.util.List;

/**
 *
 * @author Oley
 */
public interface ISalasDAO {

    public void guardar(Salas salas) throws PersistenciaException;

    List<SalasTablaDTO> buscarSalaTabla(SalaFiltroTablaDTO filtro) throws PersistenciaException;
    
    void editar(Salas salas) throws PersistenciaException;

    Salas buscarPorID(int id) throws PersistenciaException;

    Salas eliminar(int id) throws PersistenciaException;

    public Salas buscarSalasPorNombre(String nombreSalas) throws PersistenciaException;
}
