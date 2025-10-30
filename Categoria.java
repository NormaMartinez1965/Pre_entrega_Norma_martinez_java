package Inicio;


public class Categoria {

    private int id;                 // Identificador único
    private String nombre;          // Nombre de la categoría

    private static int contador = 1; // Contador compartido

    public Categoria(String nombre) { // Constructor
        this.id = contador++;         // Asigna id autoincremental
        this.nombre = nombre;         // Setea nombre
    }

    public int getId() {              // Getter id
        return id;
    }

    public String getNombre() {       // Getter nombre
        return nombre;
    }

    public void setNombre(String nombre) { // Setter nombre
        this.nombre = nombre;
    }

    @Override
    public String toString() {         // Representación legible
        return "Categoria{id=" + id + ", nombre='" + nombre + "'}";
    }
}

