
package actividadClase7;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Alberto
 */
public class Principal {

    
    public static void main(String[] args) {
        
                try (ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream("datos.dat"))){
                
                    ArrayList<String> lista = (ArrayList<String>) flujoEntrada.readObject();
                    String cadena = (String) flujoEntrada.readObject();
                    Map<Integer,String> mapa = (Map<Integer,String>) flujoEntrada.readObject();
                    
                    System.out.println("Contenido del arraylist:");
                    System.out.println(lista);
                    System.out.println("Contenido del string:");
                    System.out.println(cadena);
                    System.out.println("Contenido del mapa:");
                    System.out.println(mapa);
                            
                } catch (IOException ex) {
                    System.out.println(ex);
                } catch (ClassNotFoundException cex){
                    System.out.println(cex.getMessage());
                }

    }
    
}
