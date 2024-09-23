/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Persistencia.IClientesDAO;
import Persistencia.PersistenciaException;
import dtoCinepolis.ClientesDTO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Oley
 */
public class ClientesNegocio implements IClientesNegocios {

    private final IClientesDAO clientesDAO;

    public ClientesNegocio(IClientesDAO clientesDAO) {
        this.clientesDAO = clientesDAO;
    }

//    private Clientes DTOaEntidad(ClientesDTO clientesDTO) {
//        Clientes clientes = new Clientes();
//        clientes.setNombre(clientesDTO.getNombre());
//        clientes.setApellidoPaterno(clientesDTO.getApellidoPaterno());
//        clientes.setApellidoMaterno(clientesDTO.getApellidoMaterno());
//        clientes.setFechaNacimiento(clientesDTO.getFechaNacimiento()); // Asumiendo que este es LocalDateTime
//        clientes.setCorreo(clientesDTO.getCorreo());
//        clientes.setContraseña(clientesDTO.getContraseña());
//        clientes.setCiudad(clientesDTO.getCiudad());
//        return clientes;
//    }
//    @Override
//    public void guardar(ClientesDTO clientesDTO) throws PersistenciaException {
//        Clientes clientes = DTOaEntidad(clientesDTO);        
//        Ciudad ciudad = new Ciudad(clientesDTO.getCiudad());
//        clientesDAO.guardar(clientes, ciudad);
//        
//    }
    @Override
    public void guardar(ClientesDTO clientesDTO) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean iniciarSesion(ClientesDTO correo, ClientesDTO contrasena) throws NegocioException {
        try {
            // Asumiendo que clientesDAO tiene un método iniciarSesion que acepta Strings
            boolean esValido = clientesDAO.iniciarSesion(correo, contrasena);

            if (esValido) {
                return true;  // Credenciales válidas
            } else {
                // Mostrar mensaje de error
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos",
                        "Error de Autenticación", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (Exception e) {  // Cambié ESQLException a SQLException
            throw new NegocioException("Error al validar el usuario", e);
        }
    }

}
