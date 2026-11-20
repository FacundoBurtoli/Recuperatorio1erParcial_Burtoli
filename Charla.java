package recuperatorioparcial1_burtoli;

public class Charla extends Actividad implements Reservable, Presentable{
    
    private int minutosPreguntas;
    private int cuposDisponibles;

    public Charla(String codigo, String titulo, FranjaHoraria franja, int duracionBase, int minutosPreguntas, int cuposDisponibles ) {
        super(codigo, titulo, franja, duracionBase);
        if (minutosPreguntas < 0 ){
            throw new IllegalArgumentException("minutosPreguntas debe ser mayor a 0");
        }
        if (cuposDisponibles < 0 ){
            throw new IllegalArgumentException("cuposDisponibles debe ser mayor a 0");
        }
        this.minutosPreguntas = minutosPreguntas;
        this.cuposDisponibles = cuposDisponibles;
    }

    @Override
    public int calcularDuracionTotal() {
        return duracionBase + minutosPreguntas;
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
    public void presentar() {
        System.out.println("Presentacion de la charla: " + titulo);
    }

    @Override
    public String toString() {
        return "Charla {codigo=" + codigo + ", titulo=" + titulo + ", franja=" + franja + ", duracionBase=" + duracionBase + ", minutos Preguntas=" + minutosPreguntas + ",cupos=" + cuposDisponibles + "}";
    }
    
}
