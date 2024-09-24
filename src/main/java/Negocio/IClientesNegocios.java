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

    boolean iniciarSesion(String  correo, String  contrasena) throws NegocioException;

    void guardarClientesConCiudad(ClientesDTO clientesDTO,String nombre) throws NegocioException;
}
