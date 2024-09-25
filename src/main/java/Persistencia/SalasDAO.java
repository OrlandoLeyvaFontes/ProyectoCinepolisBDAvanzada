/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidad.Salas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Oley
 */
public class SalasDAO implements ISalasDAO {

    private final ConexionBD ConexionBD;

    public SalasDAO(ConexionBD ConexionBD) {
        this.ConexionBD = ConexionBD;
    }

    @Override
    public void guardar(Salas salas) throws PersistenciaException {
        String SQInsertarSalas = "INSERT INTO salas(nombre, cantAsientos, tiempoLimpieza, sucursal,costoSugerido) VALUES(?, ?, ?, ?,?)";
        try (Connection conexion = ConexionBD.crearConexion(); PreparedStatement insertarSalasStmt = conexion.prepareStatement(SQInsertarSalas)) {

            if (salas.getNombre() == null || salas.getNombre().isEmpty()) {
                throw new PersistenciaException("El nombre de la sala no puede ser nulo o vacío.");
            }

            insertarSalasStmt.setString(1, salas.getNombre());
            insertarSalasStmt.setInt(2, salas.getCantidadAsientos());

            Timestamp timestamp = Timestamp.valueOf(salas.getTiempoLimpieza());
            insertarSalasStmt.setTimestamp(3, timestamp);

            if (salas.getSucursales() == null || salas.getSucursales().getId() <= 0) {
                throw new PersistenciaException("ID de sucursal no válido.");
            }
            insertarSalasStmt.setInt(4, salas.getSucursales().getId());
            insertarSalasStmt.setDouble(5, salas.getCostoSugerido());
            int rowsAffected = insertarSalasStmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Sala guardada correctamente.");
            } else {
                System.out.println("No se guardó ninguna sala.");
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al guardar la sala", e);
        }
    }
}
