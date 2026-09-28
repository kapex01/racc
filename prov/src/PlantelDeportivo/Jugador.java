package PlantelDeportivo;

public class Jugador {
    private String nombre;
    private int dorsal;
    private int goles;



    public Jugador(String nombre, int dorsal, int goles) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.goles = goles;

        if (nombre == null || nombre.equals("")) {
            this.nombre = "Sin nombre";
            System.out.println("El jugador quedo sin nombre");

        }else {
            this.nombre = nombre;
        }

         if (dorsal < 0 || dorsal > 99) {
            System.out.println("El dorsal debe estar entre 0 y 99");
            this.dorsal = 0;

        } else if (goles < 0) {
            System.out.println("Los goles no pueden ser negativos");
            this.goles = 0;
        }

    }

    public void anotarGoles(int cantidad) {
        if (cantidad > 0 ){
            goles += cantidad;
        }
    }

    @Override public String toString(){
        return "Nombre: " + nombre + ", Dorsal: " + dorsal + ", Goles: " + goles;
    }




    public String getNombre() {
        return this.nombre;
    }

    public int getDorsal() {
        return this.dorsal;
    }

    public int getGoles() {
        return this.goles;
    }

}
