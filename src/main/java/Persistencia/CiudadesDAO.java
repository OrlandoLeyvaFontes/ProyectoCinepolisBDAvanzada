/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidad.Ciudad;
import dtoCinepolis.CuidadFiltroTablaDTO;
import dtoCinepolis.CuidadTablaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oley
 */
public class CiudadesDAO implements ICiudadesDAO {

    private final IConexionBD conexionBD;

    public CiudadesDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Ciudad guardar(Ciudad ciudad) throws PersistenciaException {
        String sql = "INSERT INTO ciudades(nombre) VALUES(?)";
        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement prepared = conexion.prepareStatement(sql)) {
            prepared.setString(1, ciudad.getNombre());
            prepared.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaException("error", e);
        }
        return ciudad;
    }

    @Override
    public List<CuidadTablaDTO> buscarCuidadTabla(CuidadFiltroTablaDTO filtro) throws PersistenciaException {
        List<CuidadTablaDTO> cuidadesLista = new ArrayList<>();
        String sql = """
                      SELECT id, nombre 
                      FROM ciudades 
                      WHERE nombre LIKE ? 
                      LIMIT ? 
                      OFFSET ?
                      """;
        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            preparedStatement.setString(1, "%" + filtro.getFiltro() + "%");
            preparedStatement.setInt(2, filtro.getLimit());
            preparedStatement.setInt(3, filtro.getOffset());

            try (ResultSet resultado = preparedStatement.executeQuery()) {
                while (resultado.next()) {
                    CuidadTablaDTO ciudadDTO = new CuidadTablaDTO();
                    ciudadDTO.setId(resultado.getInt("id"));
                    ciudadDTO.setNombre(resultado.getString("nombre"));
                    cuidadesLista.add(ciudadDTO);
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Ocurrió un error al leer la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.", e);
        }
        return cuidadesLista;
    }

//    @Override
//    public Ciudad modificar(CiudadesDTO ciudad) throws PersistenciaException {
//       try {
//        Connection conexion = this.conexionBD.crearConexion();
//        String updateCiudad = """
//                       UPDATE ciudades
//                       SET nombre = ?
//                       WHERE id = ?
//                       """;
//        PreparedStatement prepared = conexion.prepareStatement(updateCiudad);
//        prepared.setString(1, ciudad.getNombre()); 
//        prepared.setInt(2, ciudad.getId());        
//
//        prepared.executeUpdate();
//        prepared.close();
//        conexion.close();
//
//        return buscarPorID(ciudad.getId());  
//    } catch (SQLException e) {
//        System.out.println(e.getMessage());
//        throw new PersistenciaException("Ocurrió un error al modificar, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
//    }
    @Override
    public Ciudad buscarPorID(int id) throws PersistenciaException {
        try {
            Ciudad ciudad = null;
            Connection conexion = conexionBD.crearConexion();
            String codigoSQL = """
                          SELECT nombre 
                          FROM ciudades 
                          WHERE id = ? 
                     """;
            PreparedStatement prepared = conexion.prepareStatement(codigoSQL);
            prepared.setInt(1, id);
            ResultSet resultado = prepared.executeQuery();

            if (resultado.next()) {
                ciudad = new Ciudad(resultado.getString("nombre"));
            }

            resultado.close();
            prepared.close();
            conexion.close();

            return ciudad;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new PersistenciaException("Ocurrió un error al leer la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
        }
    }

    @Override
    public void editar(Ciudad ciudad) throws PersistenciaException {
        String updateCiudad = """
                           UPDATE ciudades
                           SET nombre = ?
                           WHERE id = ?
                           """;
        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement prepared = conexion.prepareStatement(updateCiudad)) {

            prepared.setString(1, ciudad.getNombre());
            prepared.setInt(2, ciudad.getId()); // Aquí se establece el ID
            prepared.executeUpdate();
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al actualizar el cliente", ex);
        }

    }

    @Override
    public Ciudad eliminar(int id) throws PersistenciaException {
        try {
            Ciudad ciudad = buscarPorID(id);
            if (ciudad == null) {
                throw new PersistenciaException("Ocurrio un error en obtener la información de la ciudad por su clave");
            }
            Connection conexion = this.conexionBD.crearConexion();
            String updateCiudad = """
                                   UPDATE ciudades
                                                              SET estaEliminado = 1
                                                              WHERE id = ?
                                   """;
            PreparedStatement prepared = conexion.prepareStatement(updateCiudad);
            prepared.setInt(1, id);
            int filasAfectadas = prepared.executeUpdate();
            System.out.println("filasAfectadas = " + filasAfectadas);
            prepared.close();
            conexion.close();
            return ciudad;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Ocurrió un error al modificar, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
        }
    }

    public Ciudad buscarCiudadPorNombre(String nombreCiudad) throws PersistenciaException {
        String sqlBuscarCiudad = "SELECT * FROM ciudades WHERE nombre = ?";
        Ciudad ciudad = null;

        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement buscarCiudadStmt = conexion.prepareStatement(sqlBuscarCiudad)) {

            buscarCiudadStmt.setString(1, nombreCiudad);
            ResultSet resultSet = buscarCiudadStmt.executeQuery();

            if (resultSet.next()) {
                ciudad = new Ciudad();
                ciudad.setId(resultSet.getInt("id")); // Asegúrate de que "id" es el nombre correcto de la columna
                ciudad.setNombre(resultSet.getString("nombre"));
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al buscar la ciudad", e);
        }

        return ciudad;
    }

}
