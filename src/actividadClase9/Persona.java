package actividadClase9;

import java.util.Objects;

/**
 *
 * @author Alberto
 */
public class Persona {
    
    private String nombre;
    private String dni;
    private int telefono;

    public Persona(String nombre, String dni, int telefono) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
    }

    public Persona(String dni) {
        this.dni = dni;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.dni);
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
        final Persona other = (Persona) obj;
        return Objects.equals(this.dni, other.dni);
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + " DNI: " + this.dni + " Telefono: " + this.telefono;
    }
    
    
}
