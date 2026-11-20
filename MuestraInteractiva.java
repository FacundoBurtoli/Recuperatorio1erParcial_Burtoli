package recuperatorioparcial1_burtoli;

public class MuestraInteractiva extends Actividad implements Presentable{
    
    private int estaciones;

    public MuestraInteractiva(String codigo, String titulo, FranjaHoraria franja, int duracionBase, int estaciones) {
        super(codigo, titulo, franja, duracionBase);
        if (estaciones < 0 ){
            throw new IllegalArgumentException("estaciones debe ser mayor a 0");
        }
        this.estaciones = estaciones;
    }

    @Override
    public int calcularDuracionTotal() {
        return duracionBase + (5 * estaciones);
    }

    @Override
    public void presentar() {
        System.out.println("Presentacion Muestra: " + titulo);
    }

    @Override
    public String toString() {
        return "Charla {codigo=" + codigo + ", titulo=" + titulo + ", franja=" + franja + ", duracionBase=" + duracionBase + ", estaciones=" + estaciones + "}";
    }
    
}
