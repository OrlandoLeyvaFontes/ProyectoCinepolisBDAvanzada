/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Entidad.Ciudad;
import Entidad.Clientes;
import Persistencia.IClientesDAO;
import Persistencia.PersistenciaException;
import dtoCinepolis.CiudadesDTO;
import dtoCinepolis.ClienteFiltroTablaDTO;
import dtoCinepolis.ClienteTablaDTO;
import dtoCinepolis.ClientesDTO;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Oley
 */
public class ClientesNegocio implements IClientesNegocios {

    private IClientesDAO clientesDAO;
    private ICiudadesNegocio ciudadesNegocio;

    public ClientesNegocio(IClientesDAO clientesDAO, ICiudadesNegocio ciudadesNegocio) {
        this.clientesDAO = clientesDAO;
        this.ciudadesNegocio = ciudadesNegocio;
    }

    public ClientesNegocio(IClientesDAO clientesDAO) {
        this.clientesDAO = clientesDAO;
    }

    @Override
    public boolean iniciarSesion(String correo, String contrasena) throws NegocioException {
        try {
            boolean esValido = clientesDAO.iniciarSesion(correo, contrasena);

            if (esValido) {
                JOptionPane.showMessageDialog(null, "INICIO SESION",
                        ":D", JOptionPane.INFORMATION_MESSAGE);
                return true;  
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos",
                        "Error de Autenticación", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (Exception e) {  
            throw new NegocioException("Error al validar el usuario", e);
        }
    }

    public void guardarCliente(ClientesDTO clientesDTO) throws NegocioException {
        try {
            // Convertir DTO a entidad
            Clientes cliente = convertirADTO(clientesDTO);

            // Guardar el cliente
            clientesDAO.guardar(cliente);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al guardar el cliente", e);
        }
    }
        
   
    
    
   

    

    

    private Clientes convertirADTO(ClientesDTO clientesDTO) {
        if (clientesDTO == null) {
            return null;
        }
        Clientes clientes = new Clientes();
        clientes.setId(clientesDTO.getId());
        clientes.setNombre(clientesDTO.getNombre());
        clientes.setApellidoPaterno(clientesDTO.getApellidoPaterno());
        clientes.setApellidoMaterno(clientesDTO.getApellidoMaterno());
        clientes.setFechaNacimiento(clientesDTO.getFechaNacimiento());
        clientes.setCorreo(clientesDTO.getCorreo());
        clientes.setContraseña(clientesDTO.getContraseña());
        clientes.setCiudad(clientesDTO.getCiudad());
        return clientes;

    }

    private Ciudad convertirADTO(CiudadesDTO ciudadesDTO) {
        if (ciudadesDTO == null) {
            return null;
        }
        Ciudad ciudad = new Ciudad();
        ciudad.setId(ciudadesDTO.getId());
        ciudad.setNombre(ciudadesDTO.getNombre());
        return ciudad;

    }



//    @Override
//    public List<ClienteTablaDTO> buuscarClienteTabla(ClienteFiltroTablaDTO filtro) throws NegocioException {
//try{
//    List<ClienteTablaDTO> clienteLista=clientesDAO.
//}catch(PersistenciaException e){
//      System.out.println(e.getMessage());
//            throw new NegocioException(e.getMessage());
//}
//
//
//    }

    @Override
    public void editar(ClientesDTO clientesDTO) throws NegocioException {
try{
    Clientes clientes= convertirADTO(clientesDTO);
    clientesDAO.editar(clientes);
}catch(PersistenciaException ex){
            throw new NegocioException("Error al editar la ciudad: " + ex.getMessage(), ex);
}


    }

    @Override
    public ClientesDTO eliminar(int id) throws NegocioException {
 try {
        if (id <= 0) {
            throw new NegocioException("El id recibido es incorrecto");
        }

        Clientes cliente = clientesDAO.buscarPorId(id);
        if (cliente == null) {
            throw new NegocioException("No se pudo obtener el cliente con la clave ingresada");
        }

        Clientes clienteEliminado = clientesDAO.eliminar(id);
        System.out.println("Cliente eliminado: " + clienteEliminado); 

        return entidadADTO(clienteEliminado);
    } catch (PersistenciaException ex) {
        throw new NegocioException("Error de persistencia: " + ex.getMessage());
    }

    }
    private ClientesDTO entidadADTO(Clientes clientes) {
    ClientesDTO clientesDTO = new ClientesDTO();
    clientesDTO.setId(clientes.getId()); 
    clientesDTO.setNombre(clientes.getNombre());
    return clientesDTO;
}

    @Override
    public List<ClienteTablaDTO> buuscarClienteTabla(ClienteFiltroTablaDTO filtro) throws NegocioException {
try{
    List<ClienteTablaDTO> clienteLista=clientesDAO.buscarClienteTabla(filtro);
    if(clienteLista==null){
                        throw new NegocioException("No se encontraron registros con los filtros");

    }
    return clienteLista;
}catch(PersistenciaException e){
     System.out.println(e.getMessage());
            throw new NegocioException(e.getMessage());
}}

}
