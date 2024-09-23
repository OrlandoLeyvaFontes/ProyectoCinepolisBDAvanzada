/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Entidad.Ciudad;
import Entidad.Clientes;
import dtoCinepolis.ClientesDTO;

/**
 *
 * @author Oley
 */
public interface IClientesDAO {

    public void iniciarSesion(Clientes correo, Clientes contrasena) throws PersistenciaException;

    public void guardar(Clientes clientes, Ciudad cuidad) throws PersistenciaException;

    public boolean iniciarSesion(ClientesDTO correo, ClientesDTO contrasena);
}
