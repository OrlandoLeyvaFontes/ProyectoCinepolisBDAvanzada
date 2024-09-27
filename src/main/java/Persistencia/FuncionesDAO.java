/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidad.Funciones;
import dtoCinepolis.FuncionesDTO;
import dtoCinepolis.FuncionesFiltroTablaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleja
 */
public class FuncionesDAO implements IFuncionesDAO {
    
    private final IConexionBD conexionBD;

    public FuncionesDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Funciones guardar(Funciones funcion) throws PersistenciaException {
        String sql = "INSERT INTO funciones(id, nombrePelicula, horaInicio, precio, Sala, estaEliminado) VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, funcion.getId());
            ps.setString(2, funcion.getNombrePelicula());
            ps.setObject(3, funcion.getHoraInicio());
            ps.setDouble(4, funcion.getPrecio());
            ps.setInt(5, funcion.getSala());
            ps.setBoolean(6, funcion.isEstaEliminado());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaException("Error al guardar la función", e);
        }
        return funcion; // Retorna la función guardada
    }

    @Override
    public Funciones eliminar(int id) throws PersistenciaException {
        String sql = "UPDATE funciones SET estaEliminado = 1 WHERE id = ?";
        Funciones funcionEliminada = buscarPorId(id); // Buscar antes de eliminar
        if (funcionEliminada == null) {
            throw new PersistenciaException("No se encontró la función con el id: " + id);
        }

        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaException("Error al eliminar la función", e);
        }
        return funcionEliminada; // Devolver la función que fue eliminada
    }

    public Funciones buscarPorId(int id) throws PersistenciaException {
        String sql = "SELECT * FROM funciones WHERE id = ?";
        Funciones funcion = null;
        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                funcion = new Funciones( // Se corrigió el uso de la variable
                    rs.getInt("id"), // Obtener el ID correctamente
                    rs.getString("nombrePelicula"), // Asegúrate de que este campo exista en la base de datos
                    rs.getObject("horaInicio", LocalTime.class),
                    rs.getDouble("costo"), // Se cambió "costo" a "precio"
                    rs.getInt("IdSala"),
                    rs.getBoolean("estaEliminado")
                );
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al buscar la función por id", e);
        }
        return funcion;
    }

 
//   @Override
//public List<FuncionesDTO> buscarFuncionesTabla(FuncionesFiltroTablaDTO filtro) throws PersistenciaException {
//    List<FuncionesDTO> funcionesLista = new ArrayList<>();
//    String sql = """
//        SELECT id, nombre_pelicula, hora_inicio, precio, sala, esta_eliminado
//        FROM funciones
//        WHERE nombre_pelicula LIKE ?
//        LIMIT ?
//        OFFSET ?
//    """;

//    try (Connection conexion = ConexionBD.crearConexion(); PreparedStatement prepared = conexion.prepareStatement(sql)) {
//
//        prepared.setString(1, "%" + filtro.getNombrePelicula() + "%");
//        prepared.setInt(2, filtro.getLimit());
//        prepared.setInt(3, filtro.getOffset());
//
//        try (ResultSet resultado = prepared.executeQuery()) {
//            while (resultado.next()) {
//                FuncionesDTO funcionDTO = new FuncionesDTO();
//
//                funcionDTO.setId(resultado.getInt("id"));
//                funcionDTO.setNombrePelicula(resultado.getString("nombre_pelicula"));
//                
//                // Asumiendo que hora_inicio es un campo de tipo Time
//                Time horaInicio = resultado.getTime("hora_inicio");
//                if (horaInicio != null) {
//                    funcionDTO.setHoraInicio(horaInicio.toLocalTime());
//                }
//                
//                funcionDTO.setPrecio(resultado.getDouble("precio"));
//                funcionDTO.setSala(resultado.getString("sala"));
//                funcionDTO.setEstaEliminado(resultado.getBoolean("esta_eliminado"));
//
//                funcionesLista.add(funcionDTO);
//            }
//        }
//
//    } catch (SQLException ex) {
//        throw new PersistenciaException("Error al buscar funciones", ex);
//    }
//
//    return funcionesLista;
//}

    @Override
    public List<FuncionesDTO> buscarFunciones(FuncionesFiltroTablaDTO filtro) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<FuncionesDTO> buscarFuncionesTabla(FuncionesFiltroTablaDTO filtro) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

