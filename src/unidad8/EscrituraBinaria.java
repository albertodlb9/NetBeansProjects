/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author miguel
 */
public class EscrituraBinaria {
    public static void main(String[] args) {
//    Inicializamos una tabla con los enteros del 0 al 9. Luego creamos un archivo y le 
//            asociamos un flujo de salida de la clase ObjectOutputStream. A continuación, 
//                    recorremos la tabla escribiendo los enteros en él.    

        int[] tabla = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        ObjectOutputStream flujoSalida = null;
        try {
            flujoSalida = new ObjectOutputStream(new FileOutputStream("datos.dat"));
            for (int n : tabla) {
                flujoSalida.writeInt(n);
            }
            flujoSalida.writeObject(tabla);
            flujoSalida.writeObject("Hola mundo");
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            if (flujoSalida != null) {
                try {
                    flujoSalida.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }

    }
}
