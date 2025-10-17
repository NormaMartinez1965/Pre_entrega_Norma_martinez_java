package Inicio;

import java.util.Scanner;
public abstract class CrudConsola<T> {
    // cual es el constructor de la clase abstracta?
    //   - No tiene un constructor explícito, pero Java crea uno por defecto.

    protected final Scanner scanner = new Scanner(System.in); // Scanner compartido

    public abstract void crear();
    public abstract void listar();
    public abstract void actualizar();
    public abstract void eliminar();

    public void mostrarOpciones() {
        System.out.println("\n=== Menú CRUD ===");
        System.out.println("1) Crear");
        System.out.println("2) Listar");
        System.out.println("3) Actualizar");
        System.out.println("4) Eliminar");
        System.out.println("0) Volver/Salir");
        System.out.print("Opción: ");
    }
 

    // por qué estos métodos?
    //   - Porque son comunes a muchos CRUDs y evitan duplicación de código.
    //   - Porque mejoran la experiencia de usuario al manejar errores de entrada.
    //   - Porque facilitan la lectura y mantenimiento del código.
    // por qué no hacerlos estáticos?
    //   - Porque usan el Scanner de instancia (no pueden ser estáticos).
    //   - Porque podrían necesitar acceso a otros atributos/métodos de instancia en el futuro.
    //   - Porque mantenerlos como instancia permite mayor flexibilidad y personalización.
    protected int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String linea = scanner.nextLine();
                return Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                System.out.println("Debe ser un número entero.");
            }
        }
    }

    protected double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String linea = scanner.nextLine();
                return Double.parseDouble(linea.trim());
            } catch (NumberFormatException e) {
                System.out.println("Debe ser un número (use punto).");
            }
        }
    }

    protected String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
}
