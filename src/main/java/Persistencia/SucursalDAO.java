/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidad.Ciudad;
import Entidad.Sucursales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Oley
 */
public class SucursalDAO implements ISucursalDAO {

    private final IConexionBD conexionBD;

    public SucursalDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public void guardar(Sucursales sucursal) throws PersistenciaException {
        String sqlInsertarSucursal = "INSERT INTO sucursales (nombre, ciudad) VALUES (?, ?)";

        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement insertarSucursalStmt = conexion.prepareStatement(sqlInsertarSucursal)) {

            insertarSucursalStmt.setString(1, sucursal.getNombre());
            insertarSucursalStmt.setInt(2, sucursal.getCiudad().getId());

            int rowsAffected = insertarSucursalStmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Sucursal guardada correctamente.");
            } else {
                System.out.println("No se guardó ninguna sucursal.");
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al guardar la sucursal", e);
        }
    }

    @Override
    public void editar(Sucursales sucursales) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Sucursales buscarPorID(int id) throws PersistenciaException {
        try {
            Sucursales sucursales = null;
            Connection connection = conexionBD.crearConexion();
            String codigoSQL = """
                             
                             SELECT nombre
                             FROM sucursales
                             WHERE id=?;
                             """;

            PreparedStatement prepared = connection.prepareStatement(codigoSQL);
            prepared.setInt(1, id);
            ResultSet resultado = prepared.executeQuery();

            if (resultado.next()) {
                sucursales = new Sucursales(resultado.getString("nombre"));
            }
            resultado.close();
            prepared.close();
            connection.close();
            return sucursales;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new PersistenciaException("Ocurrió un error al leer la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");

        }

    }

    @Override
    public Sucursales eliminar(int id) throws PersistenciaException {
        try {
            Sucursales sucursales = buscarPorID(id);
            if (sucursales == null) {
                throw new PersistenciaException("Ocurrio un error en obtener la información de la Sucursal por su clave");

            }
            Connection conexion = this.conexionBD.crearConexion();
            String UpdateSucursal = """
                                             UPDATE sucursales
                                                                                                           SET estaEliminado = 1
                                                                                                           WHERE id = ?
                                             
                                             """;
            PreparedStatement prepared = conexion.prepareStatement(UpdateSucursal);
            prepared.setInt(1, id);
            int filasAfectadas = prepared.executeUpdate();
            System.out.println("filasAfectadas" + filasAfectadas);
            prepared.close();
            conexion.close();
            return sucursales;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Ocurrió un error al modificar, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");

        }

    }
}
