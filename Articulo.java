package Inicio;

public class Articulo {
    // que es el encapsulamiento?
    // Es una forma de proteger los datos de una clase, restringiendo el acceso directo a sus atributos.
    // atributos privados --> solo se pueden acceder mediante metodos publicos (getters y setters)
    // beneficios: control sobre los datos, validacion, mantenimiento, seguridad
    // ejemplo: si queremos que el precio de un articulo no sea negativo, podemos validar en el setter
    // si el atributo es publico, cualquiera puede modificarlo sin restricciones
    private int id;
    private String nombre;
    private double precio;
    // para poder hacer uso de la clase Categoria dentro de Articulo tiene que existir previamente
    private Categoria categoria;

    // contador estatico para asignar ids unicos a cada articulo
    //static porque es compartido por todas las instancias de la clase
    private static int contador = 1;
    // constructor sin parametros por defecto que crea java automaticamente y solo crea una instancia en memoria sin inicializar atributos

    // Los constructores son metodos especiales que se llaman cuando se crea una instancia de una clase
    // Sirven para inicializar los atributos de la clase
    // Si no definimos un constructor, java crea uno por defecto sin parametros
    // Podemos sobrecargar el constructor creando varios con diferentes parametros
    // Los constructores no son methods static porque se llaman cuando se crea una instancia de la clase
    // No tienen tipo de retorno ni void
    // El nombre del constructor es el mismo que el de la clase

    public Articulo(){}
    // constructor con parametros(sobrecargamos el method constructor)
    public Articulo(String nombre, double precio, Categoria categoria) {

        // this hace referencia a la instancia actual de la clase
        // this.nombre hace referencia al atributo nombre de la instancia actual
        // nombre hace referencia al parametro del constructor
        // this se usa para diferenciar entre el atributo y el parametro cuando tienen el mismo nombre
        // this es opcional si no hay ambiguedad entre atributo y parametro
        // this es obligatorio cuando hay ambiguedad entre atributo y parametro
        // es buena practica usarlo siempre para mejorar la legibilidad del codigo
        this.id = contador++;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }
    // getters y setters
    // para que sirven?
    // Permiten acceder y modificar los atributos privados de una clase desde fuera de la clase
    // Getters: devuelven el valor de un atributo
    // Setters: modifican el valor de un atributo
    // Validacion: podemos validar los datos antes de asignarlos a un atributo en el setter
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
      /* if (precio < 0){ 
            this.precio = 0; 
        }else{ 
           this.precio = precio; 
        } */ 
        this.precio = precio;
    }
    // setPrecio que valide que el precio no sea negativo
    // if (precio < 0) { this.precio = 0; } else { this.precio = precio; }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // ejemplo de un method que no es un getter ni un setter 
    public String mostrarInfo() {
        return "Articulo | id=" + this.id + ", nombre='" + this.nombre + "', precio=" + this.precio +
               ", categoria=" + this.categoria.getNombre() + "|";
    }
    // sobrecarga del method mostrarInfo
    public String mostrarInfo(boolean conCategoria) {
        if (conCategoria) {
            return "Articulo | id=" + this.id + ", nombre='" + this.nombre + "', precio=" + this.precio +
                   ", categoria=" + this.categoria.getNombre() + "|";
        } else {
            return "Articulo | id=" + this.id + ", nombre='" + this.nombre + "', precio=" + this.precio + "|";
        }
    }

    // sobreescribimos el metodo toString() para mostrar la informacion del articulo
    // toString() es un metodo de la clase Object que todas las clases heredan
    // sirve para representar un objeto como una cadena de texto
    // por defecto devuelve la direccion de memoria del objeto
    // podemos sobreescribirlo para mostrar la informacion que queramos
    // @Override es una anotacion que indica que estamos sobreescribiendo un metodo de la superclase
    // nos ayuda a evitar errores de sintaxis y a mejorar la legibilidad del codigo
    // ejemplo: si queremos mostrar el nombre y el precio del articulo, podemos sobreescribir toString()
    // y devolver una cadena con esa informacion
    // cuando imprimimos un objeto, java llama automaticamente al metodo toString()
    // System.out.println(articulo) --> articulo.toString()
    @Override
    public String toString() {
        return "Articulo{id=" + id + ", nombre='" + nombre + "', precio=" + precio +
               ", categoria=" + categoria.getNombre() + "}";
    }
}