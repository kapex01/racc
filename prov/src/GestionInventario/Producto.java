package Pract;

public class Producto {
    public String codigo;
    public String nombre;
    public double precio;
    public int stock;
    

    public Producto(String codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }


    public void venderUnidades(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("Error: la cantidad a vender debe ser mayor a cero, cantidad inválida.");
        } else if (cantidad > stock) {
            System.out.println("Error: no hay suficiente stock para vender "+ cantidad + " unidades de " + nombre + ".");
        } else {
            stock -= cantidad;
            System.out.println("Venta realizada: " + cantidad + " unidades de " + nombre + ". Stock restante: " + stock);
        }
    }


    public void reponerStock(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("Error: la cantidad a reponer debe ser mayor a cero.");
        } else {
            stock += cantidad;
            System.out.println("Reposición realizada: +" + cantidad + " unidades de " + nombre + ". Stock actual: " + stock);
        }
    }


    public void actualizarPrecio(double precio) {
        double precioAnterior = this.precio;
        this.precio = precio;
        System.out.println("Precio actualizado de " + nombre + ": $" + precioAnterior + " ---> $" + this.precio);

    }


    //des
    public void aplicarDescuento(double porcentaje) {
    if (porcentaje <= 0 || porcentaje > 100) {
        System.out.println("Error: el porcentaje de descuento debe estar entre 0 y 100.");
    } else {
        double precioAnterior = this.precio;
        this.precio = this.precio - (this.precio * porcentaje / 100);
        System.out.println("Descuento aplicado a " + nombre + ": " + porcentaje + "% |||||||||| Precio anterior: $"
        + precioAnterior + ", Precio nuevo: $" + this.precio);
    }
}


    public void mostrarFicha() {
        System.out.println("/////// FICHA DE PRODUCTO ///////");
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Stock:  " + stock);
        System.out.println("/////////////////////////////////");

    }


}