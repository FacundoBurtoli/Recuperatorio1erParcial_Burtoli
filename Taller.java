package recuperatorioparcial1_burtoli;

public class Taller extends Actividad implements Reservable{
    
    private int minutosPractica;
    private int cuposDisponibles;

    public Taller(String codigo, String titulo, FranjaHoraria franja, int duracionBase, int minutosPractica, int cuposDisponibles) {
        super(codigo, titulo, franja, duracionBase);
        if (minutosPractica < 0 ){
            throw new IllegalArgumentException("minutosPreguntas debe ser mayor a 0");
        }
        if (cuposDisponibles < 0 ){
            throw new IllegalArgumentException("cuposDisponibles debe ser mayor a 0");
        }
        this.minutosPractica = minutosPractica;
        this.cuposDisponibles = cuposDisponibles;
    }

    @Override
    public int calcularDuracionTotal() {
        return duracionBase + minutosPractica;
    }

    @Override
    public void reservarLugar() {
       if(cuposDisponibles  <= 0){
            throw new IllegalArgumentException("No quedan cupos disponibles");
        }
 
        cuposDisponibles--;
    }

    @Override
    public int getCuposDisponibles() {
        return cuposDisponibles;
    }

    @Override
    public String toString() {
        return "Charla {codigo=" + codigo + ", titulo=" + titulo + ", franja=" + franja + ", duracionBase=" + duracionBase + ", minutos Practica=" + minutosPractica + ",cupos=" + cuposDisponibles + "}";
    }
}
