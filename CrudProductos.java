package Inicio;

import java.util.ArrayList;
import java.util.Scanner;

public class CrudProductos {
    private ArrayList<Producto> productos;
    private ArrayList<Categoria> categorias;
    private Scanner scanner;

    public CrudProductos(ArrayList<Producto> productos, ArrayList<Categoria> categorias, Scanner scanner) {
        this.productos = productos;
        this.categorias = categorias;
        this.scanner = scanner;
    }

    public void mostrarOpciones() {
        System.out.println("\n--- CRUD de Productos ---");
        System.out.println("1) Crear producto");
        System.out.println("2) Listar productos");
        System.out.println("3) Actualizar producto");
        System.out.println("4) Eliminar producto");
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
        if (categorias.isEmpty()) {
            System.out.println("Antes de crear un producto, debe crear una categoría.");
            return;
        }

        System.out.print("Ingrese nombre del producto: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("Ingrese precio del producto: ");
        double precio;
        try {
            precio = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Precio inválido.");
            return;
        }

        System.out.println("Seleccione una categoría:");
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println((i + 1) + ") " + categorias.get(i).getNombre());
        }

        int indice = leerEntero("Opción: ") - 1;
        if (indice < 0 || indice >= categorias.size()) {
            System.out.println("Categoría inválida.");
            return;
        }

        Categoria categoriaSeleccionada = categorias.get(indice);
        Producto nuevoProducto = new Producto(nombre, precio, categoriaSeleccionada);
        productos.add(nuevoProducto);

        System.out.println("Producto creado con código: " + nuevoProducto.getCodigo());
    }

    public void listar() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        System.out.println("\n--- Lista de Productos ---");
        for (Producto p : productos) {
            System.out.println("Código: " + p.getCodigo() +
                    " | Nombre: " + p.getNombre() +
                    " | Precio: $" + p.getPrecio() +
                    " | Categoría: " + p.getCategoria().getNombre());
        }
    }

    public void actualizar() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos creados.");
            return;
        }

        listar();
        int codigo = leerEntero("Ingrese el código del producto a modificar: ");
        Producto productoAModificar = null;

        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                productoAModificar = p;
                break;
            }
        }

        if (productoAModificar != null) {
            System.out.print("¿Desea modificar el nombre? (S/N): ");
            String respuestaNombre = scanner.nextLine().trim().toUpperCase();
            if (respuestaNombre.equals("S")) {
                System.out.print("Nuevo nombre (actual: " + productoAModificar.getNombre() + "): ");
                String nuevoNombre = scanner.nextLine().trim();
                if (!nuevoNombre.isEmpty()) {
                    productoAModificar.setNombre(nuevoNombre);
                }
            }

            System.out.print("¿Desea modificar el precio? (S/N): ");
            String respuestaPrecio = scanner.nextLine().trim().toUpperCase();
            if (respuestaPrecio.equals("S")) {
                System.out.print("Nuevo precio (actual: $" + productoAModificar.getPrecio() + "): ");
                String entrada = scanner.nextLine().trim();
                try {
                    double nuevoPrecio = Double.parseDouble(entrada);
                    productoAModificar.setPrecio(nuevoPrecio);
                } catch (NumberFormatException e) {
                    System.out.println("Precio inválido. No se pudo modificar.");
                }
            }

            System.out.println("Producto modificado correctamente.");
        } else {
            System.out.println("No se encontró un producto con ese código.");
        }
    }

    public void eliminar() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos creados.");
            return;
        }

        listar();
        int codigo = leerEntero("Ingrese el código del producto a eliminar: ");
        Producto productoAEliminar = null;

        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                productoAEliminar = p;
                break;
            }
        }

        if (productoAEliminar != null) {
            productos.remove(productoAEliminar);
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("No se encontró un producto con ese código.");
        }
    }
}
