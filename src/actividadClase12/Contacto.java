
package actividadClase12;

import java.io.Serializable;

/**
 *
 * @author alberto
 */
public class Contacto implements Serializable{
    
    private String nombre;
    private String apellido;
    private int telefono;
    private String email;

    public Contacto(String nombre, String apellido, int telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    public Contacto(int telefono) {
        this.telefono = telefono;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Contacto{" + "nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", email=" + email + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.telefono;
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
        final Contacto other = (Contacto) obj;
        return this.telefono == other.telefono;
    }
    
    
    
}
