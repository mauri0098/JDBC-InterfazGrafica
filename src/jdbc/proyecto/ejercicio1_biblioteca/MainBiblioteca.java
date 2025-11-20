/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.proyecto.ejercicio1_biblioteca;

/**
 *
 * @author Mauri
 */

public class MainBiblioteca {

    public static void main(String[] args) {
        LibroDAO dao = new LibroDAO();

        try {
            // ============================
            // INSERTAR VARIOS LIBROS
            // ============================
            System.out.println("=== Insertar libros ===");

            Libro l1 = new Libro("IT", "Stephen King", 1986, "ISBN-001", true);
            Libro l2 = new Libro("Harry Potter y la Piedra Filosofal", "J.K. Rowling", 1997, "ISBN-002", true);
            Libro l3 = new Libro("El Señor de los Anillos", "J.R.R. Tolkien", 1954, "ISBN-003", false);
            Libro l4 = new Libro("Carrie", "Stephen King", 1974, "ISBN-004", true);

            dao.agregar(l1);
            dao.agregar(l2);
            dao.agregar(l3);
            dao.agregar(l4);

            // ============================
            // LISTAR TODOS LOS LIBROS
            // ============================
            System.out.println("\n=== Listar todos los libros ===");
            dao.listarTodos().forEach(System.out::println);

            // ============================
            // BUSCAR POR AUTOR
            // ============================
            System.out.println("\n=== Buscar por autor: King ===");
            dao.buscarPorAutor("King").forEach(System.out::println);

            // ============================
            // LISTAR SOLO DISPONIBLES
            // ============================
            System.out.println("\n=== Libros disponibles ===");
            dao.listarDisponibles().forEach(System.out::println);

            // ============================
            // ACTUALIZAR UN LIBRO
            // ============================
            System.out.println("\n=== Actualizar un libro (IT -> no disponible) ===");
            l1.setDisponible(false);
            dao.actualizar(l1);

            // ============================
            // LISTAR DESPUÉS DEL UPDATE
            // ============================
            System.out.println("\n=== Después del UPDATE ===");
            dao.listarTodos().forEach(System.out::println);

            // ============================
            // ELIMINAR UN LIBRO
            // ============================
            System.out.println("\n=== Eliminar un libro (Harry Potter) ===");
            dao.eliminar(l2.getId());

            // ============================
            // LISTAR DESPUÉS DEL DELETE
            // ============================
            System.out.println("\n=== Después del DELETE ===");
            dao.listarTodos().forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

