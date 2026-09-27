package Pract2;

public class Libro {

    private final String titulo;
    private final String autor;
    private final String isbn;
    private int copiasDisponibles;
    private double precioReposicion;
    //des
    private int prestamosHistoricos;

    // Constructor canónico: único lugar donde vive la validación completa.
    public Libro(String titulo, String autor, String isbn, int copiasDisponibles, double precioReposicion) {

        if (titulo == null || titulo.isBlank()) {
            System.out.println("Título inválido, se usó \"Sin título\" por defecto.");
            titulo = "Sin título";
        }
        if (autor == null || autor.isBlank()) {
            System.out.println("Autor inválido, se usó \"Autor desconocido\" por defecto.");
            autor = "Autor desconocido";
        }
        if (isbn == null || isbn.isBlank()) {
            System.out.println("ISBN inválido, se usó \"ISBN pendiente\" por defecto.");
            isbn = "ISBN pendiente";
        }

        
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;


        if (copiasDisponibles < 0) {
            System.out.println("Copias disponibles inválidas (" + copiasDisponibles + "), se usó 0 por defecto.");
            copiasDisponibles = 0;
        }


        this.copiasDisponibles = copiasDisponibles;


        // Reutiliza la misma regla que el setter: si la rechaza, se aplica el valor por defecto.
        if (!setPrecioReposicion(precioReposicion)) {
            System.out.println("Precio de reposición inválido (" + precioReposicion + "), se usó $15000.0 por defecto.");
            this.precioReposicion = 15000.0;

        }
    }

    // Constructor de conveniencia: delega en el canónico, sin repetir ninguna validación.
    public Libro(String titulo, String autor, String isbn) {
        this(titulo, autor, isbn, 1, 15000.0);
        
    }


    public boolean setPrecioReposicion(double precio) {
         if (precio > 0) {
            this.precioReposicion = precio;
            return true;
        }
        return false; // se rechaza, el precio anterior queda intacto
    }


    public boolean prestar() {
        prestamosHistoricos++;  // Incrementa el contador de préstamos históricos (des)
        if (copiasDisponibles > 0) {
            copiasDisponibles--;
            System.out.println("Préstamo registrado: \"" + titulo + "\". Copias disponibles: " + copiasDisponibles);
            return true;
        }
        System.out.println("Error: no hay copias disponibles de \"" + titulo + "\" para prestar.");
        return false;
    }


    public void devolver() {
        copiasDisponibles++;
        System.out.println("Devolución registrada: \"" + titulo + "\". Copias disponibles: " + copiasDisponibles);

    }


    public void mostrarFicha() {
        System.out.println("======= FICHA DE LIBRO =======");
        System.out.println("Título:  " + titulo);
        System.out.println("Autor:   " + autor);
        System.out.println("ISBN:    " + isbn);
        System.out.println("Copias disponibles: " + copiasDisponibles);
        System.out.println("Precio de reposición: $" + precioReposicion);
        System.out.println("==============================");

    }


    public String getTitulo() {
        return titulo;
    }
 

    public String getAutor() {
        return autor;
    }
 

    public String getIsbn() {
        return isbn;
    }
 

    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }
 
    
    public double getPrecioReposicion() {
        return precioReposicion;
    }

    //des
    public int getPrestamosHistoricos() {
        return prestamosHistoricos;
    }

}