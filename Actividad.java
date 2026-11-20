
package recuperatorioparcial1_burtoli;

import java.util.Objects;


public abstract class Actividad {
    
    protected String codigo;
    protected String titulo;
    protected FranjaHoraria franja;
    protected int duracionBase;

    public Actividad(String codigo, String titulo, FranjaHoraria franja, int duracionBase) {
        if (codigo == null){
            throw new IllegalArgumentException("Codigo no puede ser nulo");
        }
        if (titulo == null){
            throw new IllegalArgumentException("titulo no puede ser nulo");
        }
        if (franja == null){
            throw new IllegalArgumentException("franja no puede ser nulo");
        }
        if (duracionBase < 0 ){
            throw new IllegalArgumentException("duracionBase debe ser mayor a 0");
        }
        this.codigo = codigo;
        this.titulo = titulo;
        this.franja = franja;
        this.duracionBase = duracionBase;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public FranjaHoraria getFranja() {
        return franja;
    }

    public int getDuracionBase() {
        return duracionBase;
    }
    
    public abstract int calcularDuracionTotal();

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.codigo);
        hash = 59 * hash + Objects.hashCode(this.titulo);
        hash = 59 * hash + Objects.hashCode(this.franja);
        hash = 59 * hash + this.duracionBase;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Actividad other = (Actividad) obj;
        if (this.duracionBase != other.duracionBase) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return this.franja == other.franja;
    }
    
}
