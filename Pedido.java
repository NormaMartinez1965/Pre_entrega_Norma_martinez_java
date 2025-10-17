package Inicio;

import java.util.ArrayList;

public class Pedido {
    private static int contador = 1;
    private int id;
    private Usuario usuario;
    private ArrayList<Producto> productos;
    private String fecha;
    private String estado;

    public Pedido(Usuario usuario, ArrayList<Producto> productos, String fecha, String estado) {
        this.id = contador++;
        this.usuario = usuario;
        this.productos = productos;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
