package recuperatorioparcial1_burtoli;

import java.util.List;

public class RecuperatorioParcial1_Burtoli {
        
public static void main(String[] args) throws ActividadDuplicadaException {
    Festival festival = new Festival("Ciencia Abierta");
    festival.agregarActividad(new Charla("C01", "IA Creativa", FranjaHoraria.MATUTINA, 40, 10, 2));
    festival.agregarActividad(new Taller("T02", "Robotica", FranjaHoraria.VESPERTINA, 60, 30, 1));
    festival.agregarActividad(new MuestraInteractiva("M03", "Ciencia Viva", FranjaHoraria.MATUTINA, 25, 4));
    festival.agregarActividad(new Charla("C04", "Astronomia", FranjaHoraria.NOCTURNA, 35, 15, 1));
    festival.agregarActividad(new Taller("C01", "IA Creativa", FranjaHoraria.NOCTURNA, 20, 5, 3));
    System.out.println("ACTIVIDADES");
    mostrarActividades(festival.obtenerActividades());
    System.out.println("DURACIONES");
    mostrarDuraciones(festival.obtenerActividades());
    System.out.println("PRESENTACIONES");
    realizarPresentaciones(festival.obtenerActividades());
    System.out.println("RESERVAS");
    reservarActividades(festival.obtenerActividades());
    System.out.println("MATUTINA");
    mostrarActividades(festival.filtrarPorFranja(FranjaHoraria.MATUTINA));
    System.out.println("HASTA 50 MINUTOS");
    mostrarActividades(festival.obtenerActividadesDeDuracionMaxima(50));
    }

    private static void mostrarActividades(List<Actividad> actividades) {
        for (Actividad a: actividades){
            System.out.println(a);
        }
    }
        
    private static void mostrarDuraciones(List<Actividad> actividades) {
    for (Actividad a: actividades){
            System.out.println(a.getTitulo() + ": " + a.calcularDuracionTotal() + " minutos");
        }
    }
    
    private static void realizarPresentaciones(List<Actividad> actividades) {
        for (Actividad a: actividades){
            if(a instanceof Presentable presentable){
                presentable.presentar();
            } else {
                System.out.println("a.getTitulo()" + " no realiza presentacion");
            }
            
        }
    }
    
    
    private static void reservarActividades(List<Actividad> actividades) {
    for (Actividad a: actividades){
            if(a instanceof Reservable reservable){
                reservable.reservarLugar();
                System.out.println("Reserva confirmada para " + a.getTitulo() + "cupos restantes: " + reservable.getCuposDisponibles());
            } else {
                System.out.println("a.getTitulo()" + " no admite reservas");
            }
            
        }
    }
    
}

