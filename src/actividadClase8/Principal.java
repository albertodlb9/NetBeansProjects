
package actividadClase8;

import java.io.ObjectInputStream;
import java.util.Scanner;

/**
 *
 * @author Alberto
 */
public class Principal {
    
    private static Scanner sc;
    private static String archivo = "firmas.dat";
    

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        menu();
    }
    
    private static void menu(){
        int opcion;
        do{
            System.out.println("-----------MENU-----------");
            System.out.println("1. Mostrar firmas");
            System.out.println("2. Añadir firma");
            System.out.println("3. Salir");
            System.out.print("Introduzca su opcion: ");
            opcion = sc.nextInt();

            switch(opcion){
                case 1:{
                    mostrarFirmas();
                    break;
                }
                case 2:{
                    //añadirFirma();
                    break;
                }
                case 3:{
                    System.out.println("Saliendo del programa");
                    break;
                } default:{
                    System.out.println("La opcion introducida no es correcta");
                }
            }
        } while(opcion != 3);
    }
    
    private static void mostrarFirmas(){
        //try(ObjectInputStream flujoEntrada = new ObjectInputStream(archivo)){
            
        
    }
}
