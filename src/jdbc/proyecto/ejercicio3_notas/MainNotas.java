/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.proyecto.ejercicio3_notas;

/**
 *
 * @author Mauri
 */
import java.time.LocalDate;

public class MainNotas {

    public static void main(String[] args) {

        EstudianteDAO estDao = new EstudianteDAO();
        CalificacionDAO calDao = new CalificacionDAO();

        try {
           
            System.out.println("=== Crear estudiante 1 ===");
            Estudiante e1 = new Estudiante("Juan", "Pérez", 20);
            estDao.agregar(e1);
            System.out.println("Estudiante creado: " + e1);

            System.out.println("\n=== Registrar calificaciones para Juan ===");
            calDao.agregar(new Calificacion(e1.getId(), "Matemática", 8.5, LocalDate.now().minusDays(2)));
            calDao.agregar(new Calificacion(e1.getId(), "Lengua", 9.0, LocalDate.now().minusDays(1)));
            calDao.agregar(new Calificacion(e1.getId(), "Historia", 7.5, LocalDate.now()));

            System.out.println("\n=== Historial de Juan ===");
            calDao.listarPorEstudiante(e1.getId()).forEach(System.out::println);

            System.out.println("\n=== Promedio de Juan ===");
            Double promedio1 = calDao.calcularPromedio(e1.getId());
            System.out.println("Promedio de " + e1.getNombre() + " " + e1.getApellido() + ": " + promedio1);

            
            // ESTUDIANTE 2

            System.out.println("\n===========================");
            System.out.println("=== Crear estudiante 2 ===");
            System.out.println("===========================");

            Estudiante e2 = new Estudiante("María", "González", 22);
            estDao.agregar(e2);
            System.out.println("Estudiante creado: " + e2);

            System.out.println("\n=== Registrar calificaciones para María ===");
            calDao.agregar(new Calificacion(e2.getId(), "Matemática", 6.0, LocalDate.now().minusDays(3)));
            calDao.agregar(new Calificacion(e2.getId(), "Lengua", 7.5, LocalDate.now().minusDays(2)));
            calDao.agregar(new Calificacion(e2.getId(), "Historia", 8.0, LocalDate.now()));

            System.out.println("\n=== Historial de María ===");
            calDao.listarPorEstudiante(e2.getId()).forEach(System.out::println);

            System.out.println("\n=== Promedio de María ===");
            Double promedio2 = calDao.calcularPromedio(e2.getId());
            System.out.println("Promedio de " + e2.getNombre() + " " + e2.getApellido() + ": " + promedio2);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

