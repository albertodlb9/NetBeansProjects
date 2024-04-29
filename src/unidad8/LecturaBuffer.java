/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apuntes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LecturaBuffer {
  public static void main(String[] args) {
        String texto = ""; // Declaramos la cadena fuera del try-catch para su acceso posterior
        BufferedReader in = null; 
        String rutaArchivo = "datos/datos.csv";
        try {
            in = new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            while ((linea = in.readLine()) != null) { // Mientras no lleguemos al final del archivo
                texto += linea; // no incluye saltos de línea
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
        System.out.println(texto); // mostramos el texto leído
    }
}