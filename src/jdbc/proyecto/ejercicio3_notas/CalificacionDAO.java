/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.proyecto.ejercicio3_notas;

/**
 *
 * @author Mauri
 */

import jdbc.proyecto.conexion;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalificacionDAO {

    // 1) Registrar calificación
    public void agregar(Calificacion c) throws SQLException {
        String sql = "INSERT INTO calificaciones (estudiante_id, materia, nota, fecha) VALUES (?,?,?,?)";
        try (Connection conn = conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, c.getEstudianteId());
            ps.setString(2, c.getMateria());
            ps.setDouble(3, c.getNota());
            ps.setDate(4, Date.valueOf(c.getFecha()));
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) c.setId(rs.getInt(1));
        }
    }

    // 2) Historial completo de un estudiante
    public List<Calificacion> listarPorEstudiante(int estudianteId) throws SQLException {
        List<Calificacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM calificaciones WHERE estudiante_id = ? ORDER BY fecha";

        try (Connection conn = conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, estudianteId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Calificacion c = new Calificacion();
                    c.setId(rs.getInt("id"));
                    c.setEstudianteId(rs.getInt("estudiante_id"));
                    c.setMateria(rs.getString("materia"));
                    c.setNota(rs.getDouble("nota"));
                    c.setFecha(rs.getDate("fecha").toLocalDate());
                    lista.add(c);
                }
            }
        }
        return lista;
    }

    // 3) Promedio de un estudiante
    public Double calcularPromedio(int estudianteId) throws SQLException {
        String sql = "SELECT AVG(nota) AS promedio FROM calificaciones WHERE estudiante_id = ?";
        try (Connection conn = conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, estudianteId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    double prom = rs.getDouble("promedio");
                    if (rs.wasNull()) return null; // sin notas
                    return prom;
                }
            }
        }
        return null;
    }
}
