package actividadClase3;

import java.io.*;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        String texto = ""; // Declaramos la cadena fuera del try-catch para su acceso posterior
        BufferedReader in = null; // Declaramos FileReader fuera del try-catch 
        String rutaArchivo = "datos/datos.csv";
        ArrayList<Persona> lista = new ArrayList<>();
        
        try {
            in = new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            in.readLine();
            while ((linea = in.readLine()) != null) { // Leemos caracter a caracter
                String[] palabras = linea.split(",");
                lista.add(new Persona(palabras[0],Integer.valueOf(palabras[1]),palabras[2]));
            }
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo: " + ex.getMessage());
        } finally {
            // Cerramos el flujo en cualquier caso
            if (in != null) {
                try {
                    in.close(); // Cerramos el flujo
                } catch (IOException ex) {
                    System.err.println("Error al cerrar el archivo: " + ex.getMessage());
                }
            }
        }
        
        lista.sort(null);
        System.out.println("Personas ordenadas por edad: ");
        for(Persona persona : lista){
            System.out.println(persona.toString());
        }
    }
}
