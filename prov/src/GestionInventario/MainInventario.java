package Pract;

public class MainInventario {
    public static void main(String[] args) {
        Producto productoUno = new Producto("P001", "Teclado mecánico", 45000.0, 12);
        Producto productoDos = new Producto("P002", "Mouse inalámbrico", 60000.0, 8);
        Producto productoTres = new Producto("P003", "Auriculares", 90000.0, 20);


        productoUno.mostrarFicha();
        productoUno.venderUnidades(3);
        productoUno.venderUnidades(50);
        productoUno.reponerStock(20);
        productoUno.actualizarPrecio(39000.0);
        
        Producto copiaUno = productoUno;
        copiaUno.stock = 29;
        System.out.println("Stock de productoUno tras modificar copia: " + productoUno.stock );
        //des
        productoUno.aplicarDescuento(10.0);

        System.out.println();


        productoDos.mostrarFicha();
        productoDos.venderUnidades(3);
        productoDos.venderUnidades(20);
        productoDos.reponerStock(5);
        productoDos.actualizarPrecio(55000.0);
        
        Producto copiaDos = productoDos;
        copiaDos.stock = 15; 
        System.out.println("Stock de productoDos tras modificar copiaDos: " + productoDos.stock ); 
        //des
        productoDos.aplicarDescuento(15.0);

        System.out.println();


        productoTres.mostrarFicha();
        productoTres.venderUnidades(9);
        productoTres.reponerStock(10);
        productoTres.actualizarPrecio(100000.0);
        
        Producto copiaTres = productoTres;
        copiaTres.stock = 30; 
        System.out.println("Stock de productoTres tras modificar copiaTres: " + productoTres.stock ); 
        //des
        productoTres.aplicarDescuento(30.0);

        System.out.println();
        System.out.println();   

        //des
        Producto[] productos = new Producto[3];
        productos[0] = productoUno;
        productos[1] = productoDos;
        productos[2] = productoTres;

        for (int i = 0; i < productos.length; i++) {
        productos[i].mostrarFicha();
        System.out.println();
        }



    }
}
    