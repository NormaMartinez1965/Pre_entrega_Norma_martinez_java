package Inicio;

public class Articulo {

    private int id;
    private String nombre;
    private double precio;

    private Categoria categoria;

    private static int contador = 1;
   

    public Articulo(){}
    
    public Articulo(String nombre, double precio, Categoria categoria) {

      
        this.id = contador++;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
     
        this.precio = precio;
    }
   

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
    public String mostrarInfo() {
        return "Articulo | id=" + this.id + ", nombre='" + this.nombre + "', precio=" + this.precio +
               ", categoria=" + this.categoria.getNombre() + "|";
    }
   
    public String mostrarInfo(boolean conCategoria) {
        if (conCategoria) {
            return "Articulo | id=" + this.id + ", nombre='" + this.nombre + "', precio=" + this.precio +
                   ", categoria=" + this.categoria.getNombre() + "|";
        } else {
            return "Articulo | id=" + this.id + ", nombre='" + this.nombre + "', precio=" + this.precio + "|";
        }
    }


    @Override
    public String toString() {
        return "Articulo{id=" + id + ", nombre='" + nombre + "', precio=" + precio +
               ", categoria=" + categoria.getNombre() + "}";
    }
}