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

    public boolean iniciarSesion(String  correo, String  contrasena) throws PersistenciaException;

    public void guardar(Clientes clientes) throws PersistenciaException;
    
    void editar(Clientes clientes) throws PersistenciaException;
    
    Clientes buscarPorId(int id) throws PersistenciaException;
    
    Clientes eliminar(int id) throws PersistenciaException;
    
    public  Clientes buscarCiudadPorNombre(String nombreCliente) throws PersistenciaException;
}
