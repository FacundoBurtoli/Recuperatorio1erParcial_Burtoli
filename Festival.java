package recuperatorioparcial1_burtoli;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Festival {
    
    private String nombre;
    private List<Actividad> actividades;

    public Festival(String nombre) {
        if (nombre == null){
            throw new IllegalArgumentException("nombre no puede ser nulo");
        }
        this.nombre = nombre;
        this.actividades = new ArrayList<>();

    }
    
    public void agregarActividad(Actividad actividad) throws ActividadDuplicadaException {
        if (actividad == null){
            throw new IllegalArgumentException("actividad no puede ser nulo");
        }
        
        if (actividades.contains(actividad)){
            throw new ActividadDuplicadaException("Ya existe la actividad: " + actividad.getCodigo() + " " + actividad.getTitulo());
        }
        
        actividades.add(actividad);
    }
    
    public List<Actividad> obtenerActividades(){
        return new ArrayList<>(actividades);
    }
    
    public List<Actividad> filtrarPorFranja(FranjaHoraria franja){
        Objects.requireNonNull(franja);
        List<Actividad> actividadesFiltradas = new ArrayList<>();
        
        for(Actividad a: actividades) {
            if (a.getFranja() == franja){
                actividadesFiltradas.add(a);
            }
        }
        return actividadesFiltradas;
    }
    
    public List<Actividad> obtenerActividadesDeDuracionMaxima(int limite){
        if(limite <= 0){
            throw new IllegalArgumentException("limite debe ser mayor a 0");
        }
        
        List<Actividad> actividadesFiltradas = new ArrayList<>();
        for(Actividad a: actividades) {
            if (limite > a.calcularDuracionTotal()){
                actividadesFiltradas.add(a);
            }
        }
        return actividadesFiltradas;
    }
    
    
    
}
