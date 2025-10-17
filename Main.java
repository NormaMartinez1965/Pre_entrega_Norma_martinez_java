package Inicio;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final ArrayList<Producto> productos = new ArrayList<>();
        final ArrayList<Categoria> categorias = new ArrayList<>();
        final ArrayList<Usuario> usuarios = new ArrayList<>();
        final ArrayList<Pedido> pedidos = new ArrayList<>();
        final Scanner scanner = new Scanner(System.in);

        final CrudProductos crudProd = new CrudProductos(productos, categorias, scanner);
        final CrudCategorias crudCat = new CrudCategorias(categorias, scanner);
        final CrudUsuarios crudUser = new CrudUsuarios(usuarios, scanner);
        final CrudPedidos crudPedidos = new CrudPedidos(pedidos, usuarios, productos, scanner);

        int opcion;
        do {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1) CRUD de Productos");
            System.out.println("2) CRUD de Categorías");
            System.out.println("3) CRUD de Usuarios");
            System.out.println("4) CRUD de Pedidos");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            String linea = scanner.nextLine();

            try {
                opcion = Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> {
                    int op;
                    do {
                        crudProd.mostrarOpciones();
                        op = crudProd.leerEntero("");
                        switch (op) {
                            case 1 -> crudProd.crear();
                            case 2 -> crudProd.listar();
                            case 3 -> crudProd.actualizar();
                            case 4 -> crudProd.eliminar();
                            case 0 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("Opción inválida");
                        }
                    } while (op != 0);
                }
                case 2 -> {
                    int op;
                    do {
                        crudCat.mostrarOpciones();
                        op = crudCat.leerEntero("");
                        switch (op) {
                            case 1 -> crudCat.crear();
                            case 2 -> crudCat.listar();
                            case 3 -> crudCat.actualizar();
                            case 4 -> crudCat.eliminar();
                            case 0 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("Opción inválida");
                        }
                    } while (op != 0);
                }
                case 3 -> {
                    int op;
                    do {
                        crudUser.mostrarOpciones();
                        op = crudUser.leerEntero("");
                        switch (op) {
                            case 1 -> crudUser.crear();
                            case 2 -> crudUser.listar();
                            case 3 -> crudUser.actualizar();
                            case 4 -> crudUser.eliminar();
                            case 0 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("Opción inválida");
                        }
                    } while (op != 0);
                }
                case 4 -> {
                    int op;
                    do {
                        crudPedidos.mostrarOpciones();
                        op = crudPedidos.leerEntero("");
                        switch (op) {
                            case 1 -> crudPedidos.crear();
                            case 2 -> crudPedidos.listar();
                            case 3 -> crudPedidos.actualizar();
                            case 4 -> crudPedidos.eliminar();
                            case 0 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("Opción inválida");
                        }
                    } while (op != 0);
                }
                case 0 -> System.out.println("Hasta luego");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }
}