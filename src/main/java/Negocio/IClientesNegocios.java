/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Persistencia.PersistenciaException;
import dtoCinepolis.ClienteFiltroTablaDTO;
import dtoCinepolis.ClienteTablaDTO;
import dtoCinepolis.ClientesDTO;
import java.util.List;

/**
 *
 * @author Oley
 */
public interface IClientesNegocios {

    boolean iniciarSesion(String correo, String contrasena) throws NegocioException;

//    void guardarClientesConCiudad(ClientesDTO clientesDTO, String nombre) throws NegocioException;

    List<ClienteTablaDTO> buuscarClienteTabla(ClienteFiltroTablaDTO filtro)throws NegocioException;
            
    public void guardarCliente(ClientesDTO clientesDTO) throws NegocioException;
    
   public void editar(ClientesDTO clientesDTO)  throws NegocioException;
   
   ClientesDTO eliminar(int id) throws NegocioException;
}
