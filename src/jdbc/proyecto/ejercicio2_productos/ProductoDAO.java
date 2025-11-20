/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.proyecto.ejercicio2_productos;

/**
 *
 * @author Mauri
 */
import jdbc.proyecto.conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    // INSERT
    public void agregar(Producto p) throws SQLException {
        String sql = "INSERT INTO productos (nombre, precio, stock, categoria_id) VALUES (?,?,?,?)";
        try (Connection conn = conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setInt(4, p.getCategoriaId());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) p.setId(rs.getInt(1));
        }
    }

    // LISTAR TODOS
    public List<Producto> listarTodos() throws SQLException {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try (Connection conn = conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setCategoriaId(rs.getInt("categoria_id"));
                lista.add(p);
            }
        }
        return lista;
    }

    // UPDATE
    public void actualizar(Producto p) throws SQLException {
        String sql = "UPDATE productos SET nombre=?, precio=?, stock=?, categoria_id=? WHERE id=?";
        try (Connection conn = conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setInt(4, p.getCategoriaId());
            ps.setInt(5, p.getId());
            ps.executeUpdate();
        }
    }

    // DELETE
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM productos WHERE id=?";
        try (Connection conn = conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    
    public List<String> listarProductosConCategoria() throws SQLException {
        List<String> lista = new ArrayList<>();

        String sql = """
            SELECT p.id, p.nombre AS producto, p.precio, p.stock,
                   c.nombre AS categoria
            FROM productos p
            LEFT JOIN categorias c ON p.categoria_id = c.id
            """;

        try (Connection conn = conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String linea = rs.getInt("id") + " - " +
                               rs.getString("producto") +
                               " | $" + rs.getDouble("precio") +
                               " | stock: " + rs.getInt("stock") +
                               " | categoría: " + rs.getString("categoria");
                lista.add(linea);
            }
        }
        return lista;
    }
}
