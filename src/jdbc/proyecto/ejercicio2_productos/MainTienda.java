/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.proyecto.ejercicio2_productos;

/**
 *
 * @author Mauri
 */
public class MainTienda {

    public static void main(String[] args) {
        CategoriaDAO catDao = new CategoriaDAO();
        ProductoDAO prodDao = new ProductoDAO();

        try {
            System.out.println("=== Insertar categorías ===");
            Categoria bebidas = new Categoria("Bebidas");
            Categoria snacks  = new Categoria("Snacks");

            catDao.agregar(bebidas);
            catDao.agregar(snacks);

            System.out.println("=== Categorías en BD ===");
            catDao.listarTodas().forEach(System.out::println);

            System.out.println("\n=== Insertar productos ===");
            Producto p1 = new Producto("Coca Cola 1.5L", 1200.0, 10, bebidas.getId());
            Producto p2 = new Producto("Agua Mineral 1.5L", 900.0, 20, bebidas.getId());
            Producto p3 = new Producto("Papas Fritas 100g", 750.0, 15, snacks.getId());

            prodDao.agregar(p1);
            prodDao.agregar(p2);
            prodDao.agregar(p3);

            System.out.println("\n=== Listar productos (sin join) ===");
            prodDao.listarTodos().forEach(System.out::println);

            System.out.println("\n=== Productos con nombre de categoria (JOIN) ===");
            prodDao.listarProductosConCategoria().forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
