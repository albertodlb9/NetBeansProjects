/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apuntes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


/**
 *
 * @author Miguel Angel
 */
public class LecturaScanner {
    public static void main(String[] args) {
        
        /**
         * Uso clásico de Scanner
         */
        int[] tabla = new int[5];
        Scanner s = new Scanner(System.in);
        System.out.print("Introducir serie de 5 enteros: ");
        for (int i = 0; i < 5; i++) {
            int n = s.nextInt();
            tabla[i] = n;
        }
        System.out.println(Arrays.toString(tabla));   
        
        
        /**
         * Uso de Scanner con String
         */
        String numeros = "1 34 22 0 143";
        Scanner scannerString = new Scanner (numeros);
        for (int i = 0; i < 5; i++) {
            int n = scannerString.nextInt();
            tabla[i] = n;
        }
        System.out.println(Arrays.toString(tabla)); 
        
        
        
        /**
         * Lectura de un fichero con BufferedReader y análisis con scanner
         */
        int suma = 0;

        BufferedReader bufferEntrada = null; 
        String rutaArchivo = "datos/numeros.txt";
        Scanner scannerLectura = null;
        int numero;
        try {
            bufferEntrada = new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            while ((linea = bufferEntrada.readLine()) != null) { // Mientras no lleguemos al final del archivo
                String texto = ""; 
                scannerLectura = new Scanner(linea);
                int sumaLinea = 0;
                while (scannerLectura.hasNextInt()) {
                    numero = scannerLectura.nextInt();
                    texto += numero + " ";
                    sumaLinea += numero;
                } 
                suma += sumaLinea;
                System.out.println(texto + ": " + sumaLinea);
            }
            System.out.println("Suma total: " + suma); 
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo: " + ex.getMessage());
        } finally {
            // Cerramos el flujo en cualquier caso
            if (bufferEntrada != null) {
                try {
                    bufferEntrada.close(); // Cerramos el flujo
                } catch (IOException ex) {
                    System.err.println("Error al cerrar el archivo: " + ex.getMessage());
                }
            }
        }
        

    }
}
