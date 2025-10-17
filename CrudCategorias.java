package Inicio;

import java.util.ArrayList;
import java.util.Scanner;

public class CrudCategorias {
    private ArrayList<Categoria> categorias;
    public Scanner scanner = new Scanner(System.in);

    public CrudCategorias(ArrayList<Categoria> categorias, Scanner scanner2) {
        this.categorias = categorias;
    }

    public void mostrarOpciones() {
        System.out.println("\n--- CRUD de Categorías ---");
        System.out.println("1) Crear categoría");
        System.out.println("2) Listar categorías");
        System.out.println("3) Actualizar categoría");
        System.out.println("4) Eliminar categoría");
        System.out.println("0) Volver");
        System.out.print("Opción: ");
    }

    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void crear() {
        System.out.print("Ingrese nombre de la nueva categoría: ");
        String nombre = scanner.nextLine().trim();
        categorias.add(new Categoria(nombre));
        System.out.println("Categoría creada exitosamente.");
    }

    public void listar() {
        if (categorias.isEmpty()) {
            System.out.println("No hay categorías registradas.");
            return;
        }

        System.out.println("\n--- Lista de Categorías ---");
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println((i + 1) + ") " + categorias.get(i).getNombre());
        }
    }

    public void actualizar() {
        listar();
        int indice = leerEntero("Seleccione número de categoría a actualizar: ") - 1;
        if (indice < 0 || indice >= categorias.size()) {
            System.out.println("Categoría inválida.");
            return;
        }

        System.out.print("Ingrese nuevo nombre: ");
        String nuevoNombre = scanner.nextLine().trim();
        categorias.get(indice).setNombre(nuevoNombre);
        System.out.println("Categoría actualizada.");
    }

    public void eliminar() {
        System.out.println("El programador eligió inhabilitar esta opción.");
    }
}