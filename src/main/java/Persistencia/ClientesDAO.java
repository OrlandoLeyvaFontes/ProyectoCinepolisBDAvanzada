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
            prepared.setString(6, clientes.getContraseña());
            prepared.setString(7, clientes.getCiudad());

            prepared.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaException("Error al guardar el cliente", e);
        }
    }

    @Override
    public void editar(Clientes clientes) throws PersistenciaException {
        String updateClientes = """
                                   UPDATE clientes
                                   SET nombre=?,
                                   apellidoPaterno=?
                                   , apellidoMaterno=?
                                   , fechaNacimiento=?
                                   , correo=?
                                   , contraseña=?
                                   , ciudad=?
                                   WHERE id=?
                                   """;
        try (Connection conexion = ConexionBD.crearConexion(); PreparedStatement prepa = conexion.prepareStatement(updateClientes)) {
            prepa.setString(1, clientes.getNombre());
            prepa.setString(2, clientes.getApellidoPaterno());
            prepa.setString(3, clientes.getApellidoMaterno());
            LocalDate fechaNacimiento = clientes.getFechaNacimiento();
            Timestamp timestamp = Timestamp.valueOf(fechaNacimiento.atStartOfDay());
            prepa.setTimestamp(4, timestamp);
            prepa.setString(5, clientes.getCorreo());
            prepa.setString(6, clientes.getContraseña());
            prepa.setString(7, clientes.getCiudad());
        } catch (SQLException e) {
            throw new PersistenciaException("Error al actualizar la pelicula", e);

        }

    }

    @Override
    public Clientes buscarPorId(int id) throws PersistenciaException {
        String codigoSQL = """
                      SELECT nombre
                      FROM clientes
                      WHERE id=?
                      """;
        try (Connection conexion = ConexionBD.crearConexion(); PreparedStatement prepa = conexion.prepareStatement(codigoSQL)) {
            prepa.setInt(1, id);
            try (ResultSet result = prepa.executeQuery()) {
                if (result.next()) {
                    return new Clientes(result.getString("nombre"));
                } else {
                    System.out.println("No se encontró el ID del cliente: " + id);

                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getErrorCode() + " - " + e.getMessage());
            throw new PersistenciaException("Ocurrió un error al leer la base de datos. Inténtelo de nuevo y si el error persiste, comuníquese con el encargado del sistema.");

        }
        return null;
    }

    @Override
    public Clientes eliminar(int id) throws PersistenciaException {
  try{
      Clientes clientes=buscarPorId(id);
      if(clientes==null){
                      throw new PersistenciaException("Ocurrió un error en obtener la información del cliente por su clave");

      }
      Connection connection=this.ConexionBD.crearConexion();
      String updateClientes="""
                            UPDATE clientes
                            SET estaEliminado=1
                            WHERE id=?
                            """;
      PreparedStatement preparedStatement=connection.prepareStatement(updateClientes);
      preparedStatement.setInt(1, id);
      int filasAfectadas=preparedStatement.executeUpdate();
      System.out.println("filasAfectadas = " + filasAfectadas);
      preparedStatement.close();
      return clientes;
  }catch(SQLException ex){
           System.out.println(ex.getMessage());
        throw new PersistenciaException("Ocurrió un error al modificar, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
 
  }

    }

    @Override
    public Clientes buscarClientePorNombre(String nombreCliente) throws PersistenciaException {
        String sqlBuscarCliente = "SELECT * FROM clientes  WHERE nombre";
        Clientes clientes = null;
        try (Connection conexion = ConexionBD.crearConexion(); PreparedStatement prepa = conexion.prepareStatement(sqlBuscarCliente)) {
            prepa.setString(1, nombreCliente);
            ResultSet resultSet = prepa.executeQuery();
            if (resultSet.next()) {
                clientes = new Clientes();
                clientes.setId(resultSet.getInt("id"));
                clientes.setNombre(resultSet.getString("nombre"));
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al buscar al cliente", e);

        }
        return clientes;
    }

}


