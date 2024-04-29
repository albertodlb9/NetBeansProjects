/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apuntes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

/**
 *
 * @author miguel
 */
public class LecturaBinaria {
    public static void main(String[] args) {

        try (ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream("datos.dat"))){
            int[] tablaNumeros = new int[10];
            for (int i=0; i < tablaNumeros.length; i++){
                tablaNumeros[i]=flujoEntrada.readInt();
            }
            
            Object[] tablaNumerosObject = (Object[]) flujoEntrada.readObject();
            System.out.println(tablaNumerosObject.getClass());
            String texto = (String) flujoEntrada.readObject();
            
            System.out.println(Arrays.toString(tablaNumeros));
            System.out.println(Arrays.toString(tablaNumerosObject));
            System.out.println(texto);
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException cex){
            System.out.println(cex.getMessage());
        }
    }
}
