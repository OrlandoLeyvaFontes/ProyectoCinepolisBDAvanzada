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
import dtoCinepolis.ClientesDTO;
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

//    @Override
//    public void guardarClientesConCiudad(ClientesDTO clientesDTO, String nombre) throws NegocioException {
//        try {
//            String nombreN = nombre.trim().toLowerCase();
//            CiudadesDTO ciudadesDTO = ciudadesNegocio.buscarCiudadPorNombre(nombreN);
//
//            if (ciudadesDTO == null) {
//                throw new NegocioException("Ciudad no encontrada: " + nombre);
//            }
//
//            clientesDTO.setCiudad(ciudadesDTO);
//            Clientes clientes = convertirADTO(clientesDTO);
//            clientesDAO.guardar(clientes);
//        } catch (PersistenciaException e) {
//            throw new NegocioException("Error al guardar el cliente en la capa de negocio", e);
//        }
//    }

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
//        clientes.setCiudad(convertirADTO(clientesDTO.getCiudad()));
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

    @Override
    public void guardarClientesConCiudad(ClientesDTO clientesDTO, String nombre) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
