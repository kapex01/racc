package CatalogoBiblioteca;

public class MainBiblioteca {

    public static void main(String[] args) {

        // new Libro(); // no compila: al declarar los dos constructores propios, el constructor sin argumentos que el compilador regalaba automáticamente dejó de existir.


        // Rechazo 1: título inválido (vacío) ---> se usa el valor por defecto 
        Libro libroInvalido = new Libro("", "Autor de prueba", "0000000000000", 0, 15000.0);
        System.out.println("¿Título por defecto aplicado correctamente? " + libroInvalido.getTitulo().equals("Sin título"));


        // Tres libros: combinando constructor de conveniencia y canónico 
        Libro libro1 = new Libro("Clean Code", "Robert C. Martin", "9780132350884");
        Libro libro2 = new Libro("Efectivo con Java", "Ana Restrepo", "9781234567897", 3, 22000.0);
        Libro libro3 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", "9780307474728", 2, 18500.0);


        // Rechazo 2: precio de reposición inválido (negativo) 
        double precioAnterior = libro1.getPrecioReposicion();
        boolean aceptado = libro1.setPrecioReposicion(-100.0);
        System.out.println("¿Se aceptó el precio -100.0? " + aceptado + " (se mantiene el precio anterior)");
        System.out.println("¿Se rechazó el precio y se mantuvo el anterior? " + (!aceptado && libro1.getPrecioReposicion() == precioAnterior));
                

        System.out.println();


        libro1.mostrarFicha();
        libro2.mostrarFicha();
        libro3.mostrarFicha();


        // Agotar las copias de libro1 (arrancó con 1 sola copia)
        boolean prestamo1 = libro1.prestar();
        boolean prestamo2 = libro1.prestar();
        System.out.println("¿Los préstamos se comportaron como se esperaba? " + (prestamo1 && !prestamo2 && libro1.getCopiasDisponibles() >= 0));


        libro1.devolver();


        // Actualización válida del precio de reposición 
        double precioViejo = libro1.getPrecioReposicion();
        boolean actualizado = libro1.setPrecioReposicion(18000.0);
        if (actualizado) {
            System.out.println("Precio de reposición actualizado de \"" + libro1.getTitulo() + "\": $"  + precioViejo + " ---> $" + libro1.getPrecioReposicion());
        }


        //des
        System.out.println();
        System.out.println("Historial de conteo de préstamo de \"" + libro1.getTitulo() + "\": " + libro1.getPrestamosHistoricos());


    }
}