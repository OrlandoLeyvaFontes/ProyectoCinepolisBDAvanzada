/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidad.Funciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

/**
 *
 * @author aleja
 */
public class FuncionesDAO implements IFuncionesDAO {
    
    private final IConexionBD conexionBD;

    public FuncionesDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    public Funciones guardar(Funciones funcion) throws PersistenciaException {
        String sql = "INSERT INTO funciones(nombre, costo, horaInicio, estaEliminado) VALUES(?, ?, ?, ?)";
        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, funcion.getNombre());
            ps.setInt(2, funcion.getCosto());
            ps.setObject(3, funcion.getHoraInicio());
            ps.setBoolean(4, funcion.isEstaEliminado());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaException("Error al guardar la funcion", e);
        }
        return funcion;
    }

    public Funciones eliminar(int id) throws PersistenciaException {
        String sql = "UPDATE funciones SET estaEliminado = 1 WHERE id = ?";
        Funciones funcionEliminada = null;
        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaException("Error al eliminar la función", e);
        }
        return funcionEliminada;
    }

    public Funciones buscarPorNombre(String nombre) throws PersistenciaException {
        String sql = "SELECT * FROM funciones WHERE nombre = ?";
        Funciones funcion = null;
        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                funcion = new Funciones(
                    rs.getString("nombre"),
                    rs.getInt("costo"),
                    rs.getObject("horaInicio", LocalTime.class),
                    rs.getBoolean("estaEliminado")
                );
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al buscar la funcion por nombre", e);
        }
        return funcion;
    }

}
