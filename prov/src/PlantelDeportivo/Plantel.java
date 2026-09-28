package PlantelDeportivo;

public class Plantel {

    private Jugador[] jugadores;
    private int cantidad;

    public Plantel(int capacidadInicial){
        if (capacidadInicial <=0){
            this.jugadores = new Jugador[5];
            System.out.println("el panel se inicializo con 5 jugadores");
        } else {
            jugadores = new Jugador[capacidadInicial];
        }
         cantidad = 0;

    }


    public boolean agregar(Jugador nuevojugador){
        if (nuevojugador != null){
            if (this.cantidad < this.jugadores.length){
                this.jugadores[cantidad] = nuevojugador;
                cantidad++;
                return true;
            } else {
                System.out.println("No se puede agregar el jugador, el plantel esta lleno");
                return false;
            }

        }else {
            System.out.println("jugador no valido");
            return false;
        }
    }

    public Jugador buscarPorDorsal(int dorsal){
        for (int i = 0; i < this.cantidad; i++){
            if (this.jugadores[i].getDorsal() == dorsal){
                return this.jugadores[i];
            }
        }
        return null;
    }


    public Jugador buscarPorNombre(String nombre){
        for (int i = 0; i < this.cantidad; i++){
            if (this.jugadores[i].getNombre().equals(nombre)){
                return this.jugadores[i];
            }
        }
        return null;
    }

    public boolean eliminar(int dorsal){
        Jugador[] jugadoresMenos = new Jugador[this.cantidad - 1];
        boolean encontrado = false;
         for (int i = 0 ; i < this.cantidad; i++){
            if (this.jugadores[i].getDorsal() == dorsal){
                encontrado = true;
            } else {
                if (encontrado){
                    jugadoresMenos[i - 1] = this.jugadores[i];
                } else {
                    jugadoresMenos[i] = this.jugadores[i];
                }
            }
        }

    }
 
    public void ordenarPorGolesDescendente(){

        for (int i = 0; i < this.cantidad - 1; i++) {
            int indiceMayor = i;
            for (int j = i + 1; j < this.cantidad; j++) {
                if (this.jugadores[j].getGoles() > this.jugadores[indiceMayor].getGoles()) {
                    indiceMayor = j;
                }
            }
            if (indiceMayor != i) {
                Jugador temp = this.jugadores[i];
                this.jugadores[i] = this.jugadores[indiceMayor];
                this.jugadores[indiceMayor] = temp;
            }
            
        }
        
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public int getCapacidad() {
        return this.jugadores.length;
    }
}
