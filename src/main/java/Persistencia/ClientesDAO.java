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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

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
    public boolean iniciarSesion(String correo, String contrasena) throws PersistenciaException {
        String sqlIniciarSesion = "SELECT * FROM clientes WHERE correo = ? AND contraseña = ?";

        try (Connection conexion = ConexionBD.crearConexion(); PreparedStatement prepared = conexion.prepareStatement(sqlIniciarSesion)) {
            prepared.setString(1, correo);
            prepared.setString(2, contrasena);
            ResultSet rs = prepared.executeQuery();
            
            System.out.println("Inicio");
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersistenciaException("Error al iniciar sesion", e);
        }
    }

    @Override
    public void guardar(Clientes clientes) throws PersistenciaException {
        String sqlInsertarCiudad = "INSERT INTO clientes(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, correo, contraseña, ciudad) VALUES(?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.crearConexion(); PreparedStatement prepared = conexion.prepareStatement(sqlInsertarCiudad)) {
            prepared.setString(1, clientes.getNombre());
            prepared.setString(2, clientes.getApellidoPaterno());
            prepared.setString(3, clientes.getApellidoMaterno());

            // Convertir LocalDate a Timestamp
            LocalDate fechaNacimiento = clientes.getFechaNacimiento();
            Timestamp timestamp = Timestamp.valueOf(fechaNacimiento.atStartOfDay());
            prepared.setTimestamp(4, timestamp);

            prepared.setString(5, clientes.getCorreo());
            prepared.setString(6, clientes.getContraseña()); // Considera aplicar hashing aquí
            prepared.setString(7, clientes.getCiudad()); // o prepared.setInt(7, clientes.getCiudad().getId());

            prepared.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaException("Error al guardar el cliente", e);
        }
    }

    @Override
    public void editar(Clientes clientes) throws PersistenciaException {
        String editar = "UPDATE clientes SET nombre = ?, apellidoPaterno = ?, apellidoMaterno = ?, fechaNacimiento = ?, correo = ?, contraseña = ?, ciudad = ? "
                + "WHERE id = ?";

        try (Connection conexion = ConexionBD.crearConexion(); PreparedStatement prepared = conexion.prepareStatement(editar)) {
            prepared.setString(1, clientes.getNombre());
            prepared.setString(2, clientes.getApellidoPaterno());
            prepared.setString(3, clientes.getApellidoMaterno());

            // Conversion de LocalDate a Timestamp
            LocalDate fechaNacimiento = clientes.getFechaNacimiento();
            Timestamp timestamp = Timestamp.valueOf(fechaNacimiento.atStartOfDay());
            prepared.setTimestamp(4, timestamp);

            prepared.setString(5, clientes.getCorreo());
            prepared.setString(6, clientes.getContraseña());
            prepared.setString(7, clientes.getCiudad());

            // El ID va en el último lugar
            prepared.setInt(8, clientes.getId());

            // Ejecutar la actualización
            prepared.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaException("Error al editar el cliente", e);
        }
    }

    @Override
    public void eliminar(int id) throws PersistenciaException {
        String eliminar = "UPDATE clientes SET estaEliminado = 1 WHERE id = ?";
        try (Connection conexion = ConexionBD.crearConexion(); PreparedStatement prepared = conexion.prepareStatement(eliminar)){
            prepared.setInt(1, id);
            
            prepared.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaException("Error al eliminar el cliente", e);
        }
    }

}
