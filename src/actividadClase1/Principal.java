package actividadClase1;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Principal {
    public static void main(String[] args) {
        String texto = ""; // Declaramos la cadena fuera del try-catch para su acceso posterior
        BufferedReader in = null; // Declaramos FileReader fuera del try-catch 
        String rutaArchivo = "datos/lorem_ipsum.txt";
        TreeMap <Character,Integer> mapa = new TreeMap<>();
        int contadorLetras = 0;
        try {
            in = new BufferedReader(new FileReader(rutaArchivo));

            int caracter;
            while ((caracter = in.read()) != -1) { // Leemos caracter a caracter
                if(Character.isLetter(caracter)){
                    contadorLetras++;
                    if(!mapa.containsKey((char)caracter)){
                        mapa.put((char)caracter, 1);
                    }else{
                        mapa.put((char)caracter, mapa.get((char)caracter)+1);
                    }
                }    
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
        
        System.out.println("Total de caracteres en el texto: " + contadorLetras);
        System.out.println("--------------------------------------------");
        System.out.println("Apariciones de cada letra");
        for(Map.Entry <Character,Integer> entry: mapa.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
