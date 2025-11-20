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

public class Calificacion {
    private int id;
    private int estudianteId;
    private String materia;
    private double nota;
    private LocalDate fecha;

    public Calificacion() {}

    public Calificacion(int estudianteId, String materia, double nota, LocalDate fecha) {
        this.estudianteId = estudianteId;
        this.materia = materia;
        this.nota = nota;
        this.fecha = fecha;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getEstudianteId() { return estudianteId; }
    public void setEstudianteId(int estudianteId) { this.estudianteId = estudianteId; }

    public String getMateria() { return materia; }
    public void setMateria(String materia) { this.materia = materia; }

    public double getNota() { return nota; }
    public void setNota(double nota) { this.nota = nota; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    @Override
    public String toString() {
        return "Calificación{id=" + id +
               ", est=" + estudianteId +
               ", materia='" + materia + '\'' +
               ", nota=" + nota +
               ", fecha=" + fecha +
               '}';
    }
}
