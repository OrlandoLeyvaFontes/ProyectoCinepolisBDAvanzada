/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidad.Ciudad;
import Entidad.Clientes;
import Persistencia.IClientesDAO;
import Persistencia.PersistenciaException;
import dtoCinepolis.ClientesDTO;
import java.sql.Timestamp;

/**
 *
 * @author Oley
 */
public class ClientesNegocio implements IClientesNegocios {

    private final IClientesDAO clientesDAO;
    
    public ClientesNegocio(IClientesDAO clientesDAO) {
        this.clientesDAO = clientesDAO;
    }

    private Clientes DTOaEntidad(ClientesDTO clientesDTO) {
        Clientes clientes = new Clientes();
        clientes.setNombre(clientesDTO.getNombre());
        clientes.setApellidoPaterno(clientesDTO.getApellidoPaterno());
        clientes.setApellidoMaterno(clientesDTO.getApellidoMaterno());
        clientes.setFechaNacimiento(clientesDTO.getFechaNacimiento()); // Asumiendo que este es LocalDateTime
        clientes.setCorreo(clientesDTO.getCorreo());
        clientes.setContraseña(clientesDTO.getContraseña());
        clientes.setCiudad(clientesDTO.getCiudad());
        return clientes;
    }

    @Override
    public void guardar(ClientesDTO clientesDTO) throws PersistenciaException {
        Clientes clientes = DTOaEntidad(clientesDTO);        
        Ciudad ciudad = new Ciudad(clientesDTO.getCiudad());
        clientesDAO.guardar(clientes, ciudad);
        
    }
    
}
