/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidad.Clientes;
import Persistencia.IClientesDAO;
import dtoCinepolis.ClientesDTO;
import java.time.LocalDateTime;

/**
 *
 * @author Oley
 */
public class ClientesNegocio implements IClientesNegocios {

    private final IClientesDAO clientesDAO;

    public ClientesNegocio(IClientesDAO clientesDAO) {
        this.clientesDAO = clientesDAO;
    }

//    @Override
//    public boolean iniciarSesion(ClientesDTO correo, ClientesDTO contrasena) throws NegocioException {
//        
//    }
//
//    @Override
//    public void guardar(ClientesDTO clientesDTO) throws NegocioException {
//        Clientes cliente = convertirADominio(clientesDTO);
//        Clientes clienteGuardado = this.clientesDAO.guardar(cliente, cuidad);
//    }
//    private Clientes convertirADominio(ClientesDTO clienteDTO) {
//        Clientes cliente = new Clientes();
//        cliente.setNombre(clienteDTO.getNombre());
//        cliente.setApellidoPaterno(clienteDTO.getApellidoPaterno());
//        cliente.setApellidoMaterno(clienteDTO.getApellidoMaterno());
//        cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());
//        cliente.setCiudad(clienteDTO.getCiudad());
//        cliente.setCorreo(clienteDTO.getCorreo());
//        cliente.setContraseña(clienteDTO.getContraseña());
//        return cliente;
//    }
//
//    private ClientesDTO convertitClienteDTO(Clientes clientes) {
//        ClientesDTO clienteDTO = new ClientesDTO();
//        clienteDTO.setNombre(clientes.getNombre());
//        clienteDTO.setApellidoPaterno(clientes.getApellidoPaterno());
//        clienteDTO.setApellidoMaterno(clientes.getApellidoMaterno());
//        clienteDTO.setFechaNacimiento(clientes.getFechaNacimiento());
//        clienteDTO.setCiudad(clientes.getCiudad());
//        clienteDTO.setCorreo(clientes.getCorreo());
//        clienteDTO.setContraseña(clientes.getContraseña());
//        return clienteDTO;
//    }
//    @Override
//    public CiudadesDTO guardar(CiudadesDTO ciudadDTO) throws PersistenciaException {
//        Ciudad ciudad = convertirADominio(ciudadDTO);
//        Ciudad ciudadGuardada = this.ciudadesDAO.guardar(ciudad);
//        return convertirCuidadDTO(ciudadGuardada);
//
//    }
//
//    private Ciudad convertirADominio(CiudadesDTO ciudadesDTO) {
//        Ciudad ciudad = new Ciudad();
//        ciudad.setNombre(ciudadesDTO.getNombre());
//        return ciudad;
//    }
//
//    private CiudadesDTO convertirCuidadDTO(Ciudad cuidad) {
//        CiudadesDTO cuidadDTO = new CiudadesDTO();
//        cuidadDTO.setNombre(cuidad.getNombre());
//        return cuidadDTO;
//    }

    @Override
    public boolean iniciarSesion(ClientesDTO correo, ClientesDTO contrasena) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ClientesDTO guardar(ClientesDTO clientesDTO) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editar(ClientesDTO clientesDTO) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ClientesDTO eliminar(int id) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
