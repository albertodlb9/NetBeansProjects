package actividadClas2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Principal {
    public static void main(String[] args) {
        String texto = ""; // Declaramos la cadena fuera del try-catch para su acceso posterior
        BufferedReader in = null; // Declaramos FileReader fuera del try-catch 
        String rutaArchivo = "datos/lorem_ipsum.txt";
        int contadorPalabras = 0;
        int contadorLineas = 0;
        try {
            in = new BufferedReader(new FileReader(rutaArchivo));

            String linea;
            while ((linea = in.readLine()) != null) { // Leemos caracter a caracter
                contadorLineas++;
                String[] partes = linea.split(" ");
                contadorPalabras += partes.length;
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
        
        System.out.println("Numero de lineas: " + contadorLineas);
        System.out.println("Numero de palabras: " + contadorPalabras);
    }
}
