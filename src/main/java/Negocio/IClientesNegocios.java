/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import dtoCinepolis.ClientesDTO;

/**
 *
 * @author Oley
 */
public interface IClientesNegocios {

    boolean iniciarSesion(ClientesDTO correo, ClientesDTO contrasena) throws NegocioException;

    ClientesDTO guardar(ClientesDTO clientesDTO) throws NegocioException;
    
    public void editar(ClientesDTO clientesDTO) throws NegocioException;
    
    ClientesDTO eliminar(int id) throws NegocioException;
    
    
//    CiudadesDTO guardar(CiudadesDTO ciudad) throws PersistenciaException;
//
//    List< CuidadTablaDTO> buscarCuidadTabla(CuidadFiltroTablaDTO filtro) throws NegocioException;
//
//    public void editar(CiudadesDTO ciudadesDTO) throws NegocioException;
//
//    CiudadesDTO eliminar(int id) throws NegocioException;
//
//    public CiudadesDTO buscarCiudadPorNombre(String nombreCiudad) throws NegocioException;
}
