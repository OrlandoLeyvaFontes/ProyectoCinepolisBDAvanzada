/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidad.Ciudad;
import Entidad.Clientes;
import dtoCinepolis.ClientesDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Oley
 */
public class ClientesDAO implements IClientesDAO {

    private final IConexionBD ConexionBD;

    public ClientesDAO(IConexionBD ConexionBD) {
        this.ConexionBD = ConexionBD;
    }

    @Override
    public boolean iniciarSesion(ClientesDTO correo, ClientesDTO contrasena) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void iniciarSesion(Clientes correo, Clientes contrasena) throws PersistenciaException {
        String sqlIniciarSesion = "SELECT * FROM clientes WHERE correo = ? AND contrasena = ?";

        try (Connection conexion = ConexionBD.crearConexion(); PreparedStatement prepared = conexion.prepareStatement(sqlIniciarSesion)) {
            prepared.setString(1, correo.getCorreo());
            prepared.setString(2, contrasena.getContraseña());
            prepared.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersistenciaException("Error al guardar el cliente", e);
        }
    }

    @Override
    public void guardar(Clientes clientes, Ciudad cuidad) throws PersistenciaException {
        String sqlInsertarCiudad = "INSERT INTO clientes(nombres,apellidoPaterno,apellidoMaterno,fechaNacimiento,correo,contrasena,Ciudad) VALUES(?,?,?,?,?,?,?) ";

        try (Connection conexion = ConexionBD.crearConexion(); PreparedStatement prepared = conexion.prepareStatement(sqlInsertarCiudad)) {
            prepared.setString(1, clientes.getNombre());
            prepared.setString(2, clientes.getApellidoPaterno());
            prepared.setString(3, clientes.getApellidoMaterno());
            Timestamp timestamp = Timestamp.valueOf(clientes.getFechaNacimiento());
            prepared.setTimestamp(4, timestamp);
            prepared.setString(5, clientes.getCorreo());
            prepared.setString(6, clientes.getContraseña());
            prepared.setString(7, cuidad.getNombre());
            prepared.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersistenciaException("Error al guardar el cliente", e);
        }
    }

}
