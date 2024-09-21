/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Persistencia.PersistenciaException;
import dtoCinepolis.ClientesDTO;

/**
 *
 * @author Oley
 */
public interface IClientesNegocios {
    void guardar(ClientesDTO clientesDTO) throws PersistenciaException;
}
