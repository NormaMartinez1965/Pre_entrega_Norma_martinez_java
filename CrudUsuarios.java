package Inicio;

import java.util.ArrayList;
import java.util.Scanner;

public class CrudUsuarios {
    private ArrayList<Usuario> usuarios;
    private Scanner scanner;

    public CrudUsuarios(ArrayList<Usuario> usuarios, Scanner scanner) {
        this.usuarios = usuarios;
        this.scanner = scanner;
    }

    public void mostrarOpciones() {
        System.out.println("\n--- CRUD de Usuarios ---");
        System.out.println("1) Crear usuario");
        System.out.println("2) Listar usuarios");
        System.out.println("3) Actualizar usuario");
        System.out.println("4) Eliminar usuario");
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

    private boolean esCorreoValido(String correo) {
        return correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    private boolean esTelefonoValido(String telefono) {
        return telefono.matches("^\\d{10}$");
    }

    private boolean esDniValido(String dni) {
        return dni.matches("^\\d{7,8}$");
    }

    public void crear() {
        System.out.print("Ingrese nombre del usuario: ");
        String nombre = scanner.nextLine().trim();

        String correo;
        do {
            System.out.print("Ingrese correo válido: ");
            correo = scanner.nextLine().trim();
            if (!esCorreoValido(correo)) {
                System.out.println("Formato de correo inválido.");
            }
        } while (!esCorreoValido(correo));

        String telefono;
        do {
            System.out.print("Ingrese teléfono (10 dígitos): ");
            telefono = scanner.nextLine().trim();
            if (!esTelefonoValido(telefono)) {
                System.out.println("Teléfono inválido.");
            }
        } while (!esTelefonoValido(telefono));

        System.out.print("Ingrese dirección: ");
        String direccion = scanner.nextLine().trim();

        String dni;
        do {
            System.out.print("Ingrese DNI (7 u 8 dígitos): ");
            dni = scanner.nextLine().trim();
            if (!esDniValido(dni)) {
                System.out.println("DNI inválido.");
            }
        } while (!esDniValido(dni));

        usuarios.add(new Usuario(nombre, correo, telefono, direccion, dni));
        System.out.println("Usuario creado exitosamente.");
    }

    public void listar() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        System.out.println("\n--- Lista de Usuarios ---");
        for (Usuario u : usuarios) {
            System.out.println("ID: " + u.getId() +
                    " | Nombre: " + u.getNombre() +
                    " | Correo: " + u.getCorreo() +
                    " | Teléfono: " + u.getTelefono() +
                    " | Dirección: " + u.getDireccion() +
                    " | DNI: " + u.getDni());
        }
    }

    public void actualizar() {
        listar();
        int id = leerEntero("Ingrese el ID del usuario a modificar: ");
        Usuario usuarioAModificar = null;

        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                usuarioAModificar = u;
                break;
            }
        }

        if (usuarioAModificar != null) {
            System.out.println("\n--- Datos actuales del usuario ---");
            System.out.println("Nombre: " + usuarioAModificar.getNombre());
            System.out.println("Correo: " + usuarioAModificar.getCorreo());
            System.out.println("Teléfono: " + usuarioAModificar.getTelefono());
            System.out.println("Dirección: " + usuarioAModificar.getDireccion());
            System.out.println("DNI: " + usuarioAModificar.getDni());

            System.out.print("\n¿Desea modificar el nombre? (S/N): ");
            if (scanner.nextLine().trim().equalsIgnoreCase("S")) {
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = scanner.nextLine().trim();
                if (!nuevoNombre.isEmpty()) {
                    usuarioAModificar.setNombre(nuevoNombre);
                }
            }

            System.out.print("¿Desea modificar el correo? (S/N): ");
            if (scanner.nextLine().trim().equalsIgnoreCase("S")) {
                System.out.print("Nuevo correo: ");
                String nuevoCorreo = scanner.nextLine().trim();
                if (esCorreoValido(nuevoCorreo)) {
                    usuarioAModificar.setCorreo(nuevoCorreo);
                } else {
                    System.out.println("Correo inválido. No se modificó.");
                }
            }

            System.out.print("¿Desea modificar el teléfono? (S/N): ");
            if (scanner.nextLine().trim().equalsIgnoreCase("S")) {
                System.out.print("Nuevo teléfono: ");
                String nuevoTelefono = scanner.nextLine().trim();
                if (esTelefonoValido(nuevoTelefono)) {
                    usuarioAModificar.setTelefono(nuevoTelefono);
                } else {
                    System.out.println("Teléfono inválido. No se modificó.");
                }
            }

            System.out.print("¿Desea modificar la dirección? (S/N): ");
            if (scanner.nextLine().trim().equalsIgnoreCase("S")) {
                System.out.print("Nueva dirección: ");
                String nuevaDireccion = scanner.nextLine().trim();
                if (!nuevaDireccion.isEmpty()) {
                    usuarioAModificar.setDireccion(nuevaDireccion);
                }
            }

            System.out.print("¿Desea modificar el DNI? (S/N): ");
            if (scanner.nextLine().trim().equalsIgnoreCase("S")) {
                System.out.print("Nuevo DNI: ");
                String nuevoDni = scanner.nextLine().trim();
                if (esDniValido(nuevoDni)) {
                    usuarioAModificar.setDni(nuevoDni);
                } else {
                    System.out.println("DNI inválido. No se modificó.");
                }
            }

            System.out.println("\n Usuario modificado correctamente.");
        } else {
            System.out.println("No se encontró un usuario con ese ID.");
        }
    }

    public void eliminar() {
        listar();
        int id = leerEntero("Ingrese el ID del usuario a eliminar: ");
        Usuario usuarioAEliminar = null;

        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                usuarioAEliminar = u;
                break;
            }
        }

        if (usuarioAEliminar != null) {
            usuarios.remove(usuarioAEliminar);
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("No se encontró un usuario con ese ID.");
        }
    }
}
