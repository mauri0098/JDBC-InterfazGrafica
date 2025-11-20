/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdbc.proyecto;

/**
 *
 * @author Mauri
 */

import java.sql.Connection;

public class JDBCProyecto {

    public static void main(String[] args) {
        try (Connection conn = conexion.getConnection()) {
            System.out.println("Conexión exitosa. Base: " + conn.getCatalog());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
