/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad8;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author miguel
 */
public class EscrituraFichero {
    public static void main(String[] args) {
        String nombreArchivo = "datos/ejemplo.txt";

        try {
            // Crear un FileWriter con opción para añadir al final del archivo
            FileWriter escritor = new FileWriter(nombreArchivo, true);

            // Crear un BufferedWriter para mejorar el rendimiento
            BufferedWriter bufferEscritor = new BufferedWriter(escritor);

            // Escribir en el archivo
            bufferEscritor.write("Escribiendo una línea de texto con BufferedWriter.");
                        // Escribir un salto de línea en el archivo
            bufferEscritor.newLine();


            // Escribir un carácter en el archivo
            bufferEscritor.write('A');

            // Escribir una cadena en el archivo
            bufferEscritor.write("Texto adicional.");

            // Escribir un salto de línea en el archivo
            bufferEscritor.newLine();

            // Vaciar el búfer de salida, escribiendo en el archivo los caracteres pendientes
            bufferEscritor.flush();

            // Cerrar el BufferedWriter
            bufferEscritor.close();

            System.out.println("Texto añadido al archivo correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}

