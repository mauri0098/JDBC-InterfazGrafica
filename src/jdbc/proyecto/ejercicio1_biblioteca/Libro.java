/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.proyecto.ejercicio1_biblioteca;

/**
 *
 * @author Mauri
 */
public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private String isbn;
    private boolean disponible;

    public Libro() {}

    public Libro(String titulo, String autor, int anioPublicacion, String isbn, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.isbn = isbn;
        this.disponible = disponible;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public int getAnioPublicacion() { return anioPublicacion; }
    public void setAnioPublicacion(int anioPublicacion) { this.anioPublicacion = anioPublicacion; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String toString() {
        return id + " - " + titulo + " - " + autor + 
               " (" + anioPublicacion + ") | ISBN: " + isbn +
               " | Disponible: " + disponible;
    }
}
