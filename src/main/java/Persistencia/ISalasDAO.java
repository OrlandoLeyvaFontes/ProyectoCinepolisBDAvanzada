/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidad.Salas;

/**
 *
 * @author Oley
 */
public interface ISalasDAO {
    public void guardar(Salas salas) throws PersistenciaException;
}
