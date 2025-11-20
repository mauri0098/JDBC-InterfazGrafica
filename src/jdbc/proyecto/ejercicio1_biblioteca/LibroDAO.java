/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.proyecto.ejercicio1_biblioteca;

/**
 *
 * @author Mauri
 */

import jdbc.proyecto.conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    // INSERT
    public void agregar(Libro l) throws SQLException {
        String sql = "INSERT INTO libros (titulo, autor, anio_publicacion, isbn, disponible) VALUES (?,?,?,?,?)";
        try (Connection conn = conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            ps.setInt(3, l.getAnioPublicacion());
            ps.setString(4, l.getIsbn());
            ps.setBoolean(5, l.isDisponible());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) l.setId(rs.getInt(1));
        }
    }

    // SELECT * (listar todos)
    public List<Libro> listarTodos() throws SQLException {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libros";

        try (Connection conn = conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) lista.add(mapear(rs));
        }
        return lista;
    }

    // UPDATE
    public void actualizar(Libro l) throws SQLException {
        String sql = "UPDATE libros SET titulo=?, autor=?, anio_publicacion=?, isbn=?, disponible=? WHERE id=?";
        try (Connection conn = conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            ps.setInt(3, l.getAnioPublicacion());
            ps.setString(4, l.getIsbn());
            ps.setBoolean(5, l.isDisponible());
            ps.setInt(6, l.getId());
            ps.executeUpdate();
        }
    }

    // DELETE
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM libros WHERE id=?";
        try (Connection conn = conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // EXTRA: buscar por autor
    public List<Libro> buscarPorAutor(String autor) throws SQLException {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libros WHERE autor LIKE ?";

        try (Connection conn = conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + autor + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) lista.add(mapear(rs));
        }
        return lista;
    }

    // EXTRA: listar disponibles
    public List<Libro> listarDisponibles() throws SQLException {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libros WHERE disponible = 1";

        try (Connection conn = conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) lista.add(mapear(rs));
        }
        return lista;
    }

    // METODO PRIVADO PARA MAPEAR RESULTSET
    private Libro mapear(ResultSet rs) throws SQLException {
        Libro l = new Libro();
        l.setId(rs.getInt("id"));
        l.setTitulo(rs.getString("titulo"));
        l.setAutor(rs.getString("autor"));
        l.setAnioPublicacion(rs.getInt("anio_publicacion"));
        l.setIsbn(rs.getString("isbn"));
        l.setDisponible(rs.getBoolean("disponible"));
        return l;
    }
}
