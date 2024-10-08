/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidad.Salas;
import dtoCinepolis.SalaFiltroTablaDTO;
import dtoCinepolis.SalasTablaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oley
 */
public class SalasDAO implements ISalasDAO {

    private  IConexionBD ConexionBD;

    public SalasDAO(IConexionBD ConexionBD) {
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

    @Override
    public void editar(Salas salas) throws PersistenciaException {
    if (salas == null) {
        throw new PersistenciaException("El objeto 'salas' no puede ser nulo.");
    }

    if (salas.getCantidadAsientos() <= 0) {
        throw new PersistenciaException("La cantidad de asientos debe ser mayor que 0.");
    }

    Salas salaExistente = buscarPorID(salas.getId());
    if (salaExistente == null) {
        throw new PersistenciaException("La sala con el ID proporcionado no existe.");
    }

    // Consulta SQL para actualizar la sala
    String updateSalas = """
        UPDATE salas
        SET nombre = ?, 
            cantAsientos = ?, 
            tiempoLimpieza = ?, 
            sucursal = ?, 
            costoSugerido = ?
        WHERE id = ?
    """;

    try (Connection conexion = ConexionBD.crearConexion(); 
         PreparedStatement prepared = conexion.prepareStatement(updateSalas)) {

        prepared.setString(1, salas.getNombre());
        prepared.setInt(2, salas.getCantidadAsientos());
        
        if (salas.getTiempoLimpieza() == null) {
            throw new PersistenciaException("El tiempo de limpieza no puede ser nulo.");
        }
        prepared.setTimestamp(3, Timestamp.valueOf(salas.getTiempoLimpieza()));
        
        if (salas.getSucursales() == null || salas.getSucursales().getId() == 0) {
            throw new PersistenciaException("Sucursal no válida.");
        }
        prepared.setInt(4, salas.getSucursales().getId());
        prepared.setDouble(5, salas.getCostoSugerido());
        prepared.setInt(6, salas.getId());

        int filasAfectadas = prepared.executeUpdate();
        if (filasAfectadas == 0) {
            throw new PersistenciaException("No se actualizó ninguna sala. Verifique el ID.");
        }

        System.out.println("Sala actualizada exitosamente."); // Registro para depuración

    } catch (SQLException ex) {
        ex.printStackTrace(); // Imprimir la traza de la excepción
        throw new PersistenciaException("Error al actualizar la sala: " + ex.getMessage(), ex);
    }
    }

    @Override
    public Salas buscarPorID(int id) throws PersistenciaException {
        String codigoSQL = """
        SELECT nombre
        FROM salas
        WHERE id=?""";
    try (Connection connection = ConexionBD.crearConexion();
         PreparedStatement preparedStatement = connection.prepareStatement(codigoSQL)) {

        preparedStatement.setInt(1, id);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return new Salas(resultSet.getString("nombre"));
            } else {
                System.out.println("No se encontró la sala con ID: " + id);
            }
        }
    } catch (SQLException e) {
        System.out.println("SQL Error: " + e.getErrorCode() + " - " + e.getMessage());
        throw new PersistenciaException("Ocurrió un error al leer la base de datos. Inténtelo de nuevo y si el error persiste, comuníquese con el encargado del sistema.");
    }
    return null;

    }

    @Override
    public Salas eliminar(int id) throws PersistenciaException {
        try {
        Salas salas = buscarPorID(id);
        if (salas == null) {
            throw new PersistenciaException("Ocurrió un error en obtener la información de la sala por su clave");
        }
        
        Connection connection = this.ConexionBD.crearConexion();
        String updateSalas = """
                    UPDATE salas
                    SET estaEliminado = 1  -- o el valor que desees asignar
                    WHERE id = ?
                    """;
        
        PreparedStatement preparedStatement = connection.prepareStatement(updateSalas);
        preparedStatement.setInt(1, id);
        int filasAfectadas = preparedStatement.executeUpdate();
        System.out.println("filasAfectadas = " + filasAfectadas);
        
        preparedStatement.close();
        connection.close();
        return salas;

    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        throw new PersistenciaException("Ocurrió un error al modificar, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
    }    }

    @Override
    public Salas buscarSalasPorNombre(String nombreSalas) throws PersistenciaException {
        String sqlBuscarSalas = "SELECT * FROM salas WHERE nombre=?";
        Salas salas1 = null;
        try (Connection conexion = ConexionBD.crearConexion(); PreparedStatement buscarSalasStmt = conexion.prepareStatement(sqlBuscarSalas)) {
            buscarSalasStmt.setString(1, nombreSalas);
            ResultSet resultSet = buscarSalasStmt.executeQuery();
            if (resultSet.next()) {
                salas1 = new Salas();
                salas1.setId(resultSet.getInt("id"));
                salas1.setNombre(resultSet.getString("nombre"));
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al buscar la sala", e);

        }
        return salas1;
    }

    @Override
    public List<SalasTablaDTO> buscarSalaTabla(SalaFiltroTablaDTO filtro) throws PersistenciaException {
        List<SalasTablaDTO> salaLista = new ArrayList<>();
        String sql = """
        SELECT nombre, cantAsientos, tiempoLimpieza, costoSugerido,id
        FROM salas
        WHERE nombre LIKE ?
        LIMIT ?
        OFFSET ?
    """;

        try (Connection conexion = ConexionBD.crearConexion(); PreparedStatement prepared = conexion.prepareStatement(sql)) {

            prepared.setString(1, "%" + filtro.getFiltro() + "%");
            prepared.setInt(2, filtro.getLimit());
            prepared.setInt(3, filtro.getOffset());

            try (ResultSet resultado = prepared.executeQuery()) {
                while (resultado.next()) {
                    SalasTablaDTO salasTablaDTO = new SalasTablaDTO();

                    salasTablaDTO.setNombre(resultado.getString("nombre"));
                    salasTablaDTO.setCantidadAsientos(resultado.getInt("cantAsientos"));

                    Timestamp timestamp = resultado.getTimestamp("tiempoLimpieza");
                    if (timestamp != null) {
                        salasTablaDTO.setTiempoLimpieza(timestamp.toLocalDateTime());
                    }

                    salasTablaDTO.setCostoSugerido(resultado.getDouble("costoSugerido"));
                     salasTablaDTO.setId(resultado.getInt("id"));
                    salaLista.add(salasTablaDTO);
                }
            }

        } catch (SQLException ex) {
            throw new PersistenciaException("Error al buscar salas", ex);
        }

        return salaLista;
    }
}
