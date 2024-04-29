
package actividadClase9;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Alberto
 */
public class Principal {
    
    private static Scanner sc;
    private static HashSet<Persona> conjunto;

    public static void main(String[] args) {
        
        sc = new Scanner(System.in);
        abrirArchivo();
        menu();
    }
    private static void menu(){
        int opcion;
        do{
            System.out.println("-----------MENU-----------");
            System.out.println("1. Añadir nuevo cliente");
            System.out.println("2. Modificar datos de un cliente");
            System.out.println("3. Dar de baja un cliente");
            System.out.println("4. Listar clientes");
            System.out.println("5. Guardar y salir");
            System.out.print("Introduzca su opcion: ");
            opcion = sc.nextInt();

            switch(opcion){
                case 1:{
                    añadirCliente();
                    break;
                }
                case 2:{
                    modificarCliente();
                    break;
                }
                case 3:{
                    eliminarCliente();
                    break;
                }
                case 4:{
                    mostrarClientes();
                    break;
                }
                case 5:{
                    System.out.println("Saliendo del programa");
                    break;
                } default:{
                    System.out.println("La opcion introducida no es correcta");
                }
            }
        } while(opcion != 5);
    }
    
    private static void abrirArchivo(){
        
        try(ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream("clientes.dat"))){
            conjunto = (HashSet<Persona>) flujoEntrada.readObject();
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException cex){
            System.out.println(cex.getMessage());
        }
    }
    
    private static void añadirCliente(){
        
        System.out.print("Introduzca el nombre:");
        String nombre = sc.nextLine();
        System.out.print("Introduzca el dni: ");
        String dni = sc.nextLine();
        System.out.print("Introduzca el numero de telefono: ");
        int telefono = sc.nextInt();
        
        if(conjunto.add(new Persona(nombre,dni,telefono))){
            System.out.println("Cliente añadido de forma correcta");
        } else{
            System.out.println("Cliente repetido");
        }
    }
    
    private static void modificarCliente(){
        
        System.out.print("Introduzca el dni del cliente a modificar: ");
        String dni = sc.nextLine();
        if(conjunto.contains(new Persona(dni))){
            
            
        }
    }
    
    private static Persona extraerCliente(String dni){
        Iterator<Persona> it = conjunto.iterator();
        String otroDni = dni;
        while(it.hasNext()){
            Persona persona = it.next();
            if(persona.getDni().equals(otroDni))
        }
    }
}
