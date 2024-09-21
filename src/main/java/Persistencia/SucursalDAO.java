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
public void guardar(Sucursales sucursal, Ciudad ciudad) throws PersistenciaException{
          String sqlInsertarSucursal = "INSERT INTO sucursales (nombre, ciudad) VALUES (?, ?)";

    try (Connection conexion = conexionBD.crearConexion();
         PreparedStatement insertarSucursalStmt = conexion.prepareStatement(sqlInsertarSucursal)) {

        insertarSucursalStmt.setString(1, sucursal.getNombre()); 
        insertarSucursalStmt.setString(2, ciudad.getNombre());
        int rowsAffected = insertarSucursalStmt.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Sucursal guardada correctamente.");
        } else {
            System.out.println("No se guardó ninguna sucursal.");
        }

    } catch (SQLException e) {
        System.out.println("Error SQL: " + e.getMessage());
        throw new PersistenciaException("Error al guardar la sucursal", e);
    }
    }
}
