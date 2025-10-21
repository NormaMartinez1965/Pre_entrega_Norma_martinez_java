package Inicio;

public class Usuario {
    private static int contador = 1;
    private int id;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;
    private String dni;

    public Usuario(String nombre, String correo, String telefono, String direccion, String dni) {
        this.id = contador++;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.dni = dni;
    }

    public Usuario(String nombre2, String correo2) {
        
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}