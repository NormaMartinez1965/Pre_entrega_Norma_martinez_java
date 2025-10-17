package Inicio;

import java.util.ArrayList;
import java.util.Scanner;

public class CrudPedidos {
    private ArrayList<Pedido> pedidos;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Producto> productos;
    private Scanner scanner;

    public CrudPedidos(ArrayList<Pedido> pedidos, ArrayList<Usuario> usuarios, ArrayList<Producto> productos,
            Scanner scanner) {
        this.pedidos = pedidos;
        this.usuarios = usuarios;
        this.productos = productos;
        this.scanner = scanner;
    }

    public void mostrarOpciones() {
        System.out.println("\n--- CRUD de Pedidos ---");
        System.out.println("1) Crear pedido");
        System.out.println("2) Listar pedidos");
        System.out.println("3) Modificar pedido");
        System.out.println("4) Eliminar pedido");
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
        if (usuarios.isEmpty() || productos.isEmpty()) {
            System.out.println("Debe haber al menos un usuario y un producto para crear un pedido.");
            return;
        }

        System.out.println("Seleccione un usuario:");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println((i + 1) + ") " + usuarios.get(i).getNombre());
        }
        int indiceUsuario = leerEntero("Opción: ") - 1;
        if (indiceUsuario < 0 || indiceUsuario >= usuarios.size()) {
            System.out.println("Usuario inválido.");
            return;
        }
        Usuario usuarioSeleccionado = usuarios.get(indiceUsuario);

        ArrayList<Producto> productosSeleccionados = new ArrayList<>();
        String continuar;
        do {
            System.out.println("Seleccione un producto:");
            for (int i = 0; i < productos.size(); i++) {
                System.out.println((i + 1) + ") " + productos.get(i).getNombre());
            }
            int indiceProducto = leerEntero("Opción: ") - 1;
            if (indiceProducto >= 0 && indiceProducto < productos.size()) {
                productosSeleccionados.add(productos.get(indiceProducto));
            } else {
                System.out.println("Producto inválido.");
            }
            System.out.print("¿Agregar otro producto? (S/N): ");
            continuar = scanner.nextLine().trim().toUpperCase();
        } while (continuar.equals("S"));

        System.out.print("Ingrese fecha del pedido (ej: 2025-10-17): ");
        String fecha = scanner.nextLine().trim();

        System.out.print("Ingrese estado del pedido (ej: Pendiente, Enviado, Entregado): ");
        String estado = scanner.nextLine().trim();

        Pedido nuevoPedido = new Pedido(usuarioSeleccionado, productosSeleccionados, fecha, estado);
        pedidos.add(nuevoPedido);
        System.out.println("Pedido creado con ID: " + nuevoPedido.getId());
    }

    public void listar() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
            return;
        }

        System.out.println("\n--- Lista de Pedidos ---");
        for (Pedido p : pedidos) {
            System.out.println("ID: " + p.getId() +
                    " | Usuario: " + p.getUsuario().getNombre() +
                    " | Fecha: " + p.getFecha() +
                    " | Estado: " + p.getEstado());
            System.out.println("  Productos:");
            for (Producto prod : p.getProductos()) {
                System.out.println("    - " + prod.getNombre());
            }
        }
    }

    public void actualizar() {
        listar();
        int id = leerEntero("Ingrese el ID del pedido a modificar: ");
        Pedido pedido = null;
        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                pedido = p;
                break;
            }
        }

        if (pedido == null) {
            System.out.println("No se encontró un pedido con ese ID.");
            return;
        }

        System.out.println("\n--- Modificar Pedido ---");

        System.out.println("Estado actual: " + pedido.getEstado());
        System.out.print("¿Desea modificar el estado? (S/N): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("S")) {
            System.out.print("Nuevo estado: ");
            String nuevoEstado = scanner.nextLine().trim();
            if (!nuevoEstado.isEmpty()) {
                pedido.setEstado(nuevoEstado);
                System.out.println("Estado actualizado.");
            }
        }

        System.out.print("¿Desea modificar los productos del pedido? (S/N): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("S")) {
            ArrayList<Producto> productosActuales = pedido.getProductos();

            // Reemplazar productos existentes
            for (int i = 0; i < productosActuales.size(); i++) {
                Producto actual = productosActuales.get(i);
                System.out.println("\nProducto actual: " + actual.getNombre());
                System.out.print("¿Desea reemplazar este producto? (S/N): ");
                if (scanner.nextLine().trim().equalsIgnoreCase("S")) {
                    System.out.println("Seleccione un nuevo producto:");
                    for (int j = 0; j < productos.size(); j++) {
                        System.out.println((j + 1) + ") " + productos.get(j).getNombre());
                    }
                    int nuevoIndice = leerEntero("Opción: ") - 1;
                    if (nuevoIndice >= 0 && nuevoIndice < productos.size()) {
                        productosActuales.set(i, productos.get(nuevoIndice));
                        System.out.println("Producto reemplazado.");
                    } else {
                        System.out.println("Opción inválida. Se mantiene el producto actual.");
                    }
                }
            }

            // Eliminar productos
            System.out.print("\n¿Desea eliminar algún producto del pedido? (S/N): ");
            if (scanner.nextLine().trim().equalsIgnoreCase("S")) {
                for (int i = 0; i < productosActuales.size(); i++) {
                    Producto actual = productosActuales.get(i);
                    System.out.println("Producto: " + actual.getNombre());
                    System.out.print("¿Eliminar este producto? (S/N): ");
                    if (scanner.nextLine().trim().equalsIgnoreCase("S")) {
                        productosActuales.remove(i);
                        i--; // ajustar índice tras eliminación
                        System.out.println("Producto eliminado.");
                    }
                }
            }

            // Agregar nuevos productos
            System.out.print("\n¿Desea agregar nuevos productos al pedido? (S/N): ");
            if (scanner.nextLine().trim().equalsIgnoreCase("S")) {
                String continuar;
                do {
                    System.out.println("Seleccione un producto para agregar:");
                    for (int i = 0; i < productos.size(); i++) {
                        System.out.println((i + 1) + ") " + productos.get(i).getNombre());
                    }
                    int indiceProducto = leerEntero("Opción: ") - 1;
                    if (indiceProducto >= 0 && indiceProducto < productos.size()) {
                        productosActuales.add(productos.get(indiceProducto));
                        System.out.println("Producto agregado.");
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    System.out.print("¿Agregar otro producto? (S/N): ");
                    continuar = scanner.nextLine().trim().toUpperCase();
                } while (continuar.equals("S"));
            }

            System.out.println("\n✅ Productos del pedido actualizados.");
        }
    }

    public void eliminar() {
        listar();
        int id = leerEntero("Ingrese el ID del pedido a eliminar: ");
        Pedido pedidoAEliminar = null;
        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                pedidoAEliminar = p;
                break;
            }
        }

        if (pedidoAEliminar != null) {
            pedidos.remove(pedidoAEliminar);
            System.out.println("Pedido eliminado correctamente.");
        } else {
            System.out.println("No se encontró un pedido con ese ID.");
        }
    }
}
