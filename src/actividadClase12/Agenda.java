
package actividadClase12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alberto
 */
public class Agenda {
    
    private static Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private static List<Contacto> contactos;
    private static final String FICHERO_CSV = "datos/contactos.csv";
    
    public static void main(String[] args){
        
        cargarContactos();
        menu();
    }
    
    public static void menu(){
        
        int opcion = 0;
        
        try{
            do{
                System.out.println("------------MENU-------------");
                System.out.println("1. Añadir contacto");
                System.out.println("2. Mostrar todos los contactos");
                System.out.println("3. Eliminar contacto segun numero de telefono");
                System.out.println("4. Crear un fichero de contactos VCF");
                System.out.println("5. Guardar copia de seguridad");
                System.out.println("6. Cargar contactos desde copia de seguridad");
                System.out.println("7. Guardar CSV y salir");
                System.out.print("Introduzca su opcion: ");
                opcion = sc.nextInt();

                switch(opcion){
                    case 1:{
                        nuevoContacto();
                        break;
                    }
                    case 2:{
                        mostrarContactos();
                        break;
                    }
                    case 3:{
                        eliminarContacto();
                        break;
                    }
                    case 4:{
                        crearArchivoVCF();
                        break;
                    }
                    case 5:{
                        copiaSeguridad();
                        break;
                    }
                    case 6:{
                        restablecerCopiaSeguridad();
                        break;
                    }
                    case 7:{
                        guardarContactos();
                        System.out.println("Guardando contactos...");
                        System.out.println("Saliendo del programa. Hasta luego!");
                        break;
                    }
                    default :{
                        System.err.println("Error: la opcion introducida no es correcta.");
                        break;
                    }
                }
            }while(opcion != 7);
        }
        catch(InputMismatchException e){
            System.err.println("Error: el dato introducido no es correcto.");
        }
    }
    
    public static void cargarContactos(){
        
        contactos = new ArrayList<Contacto>();
        
        try(BufferedReader in = new BufferedReader(new FileReader(FICHERO_CSV))){
            String linea;
            in.readLine();
            while((linea = in.readLine()) != null){
                String [] partes = linea.split(",");
                contactos.add(new Contacto(partes[0],partes[1],Integer.valueOf(partes[2]),partes[3]));
            }
            
        }
        catch(IOException e){
            System.err.println("");
        }
    }
    
    public static void nuevoContacto(){
        
        try{
            System.out.print("Introduzca el nombre: ");
            String nombre = sc.next();
            System.out.print("Introduzca los apellidos: ");
            String apellidos = sc.next();
            System.out.print("Introduzca el numero de telefono: ");
            int telefono = sc.nextInt();
            System.out.print("Introduzca el email: ");
            String email = sc.next();
            
            contactos.add(new Contacto(nombre,apellidos,telefono,email));
        }
        catch(InputMismatchException e){
            System.err.println("Error: el dato introducido es incorrecto.");
        }
    }
    
    public static void mostrarContactos(){
        
        Iterator<Contacto> it = contactos.iterator();
        
        while(it.hasNext()){
            Contacto contacto = it.next();
            System.out.println(contacto.toString());
        }
    }
    
    public static void eliminarContacto(){
        
        try{
            System.out.print("Introduzca el numero de telefono del contacto que desea eliminar: ");
            int telefono = sc.nextInt();
            if(contactos.contains(new Contacto(telefono))){
                contactos.remove(new Contacto(telefono));
            } else{
                System.out.println("El numero no se encuentra en sus contactos");
            }
        }
        catch(InputMismatchException e){
            System.err.println("Error: el dato introducido no es correcto");
        }
    }
    
    public static void crearArchivoVCF(){
        
        try(BufferedWriter out = new BufferedWriter(new FileWriter("datos/Contactos.vcf"))){
            Iterator<Contacto> it = contactos.iterator();
            
            while(it.hasNext()){
                Contacto contacto = it.next();
                out.write("BEGIN:VCARD");
                out.newLine();
                out.write("VERSION:3.0");
                out.newLine();
                out.write("FN:" + contacto.getNombre() + " " + contacto.getApellido());
                out.newLine();
                out.write("TEL;TYPE=CELL:" + contacto.getTelefono());
                out.newLine();
                out.write("EMAIL:" + contacto.getEmail());
                out.newLine();
                out.write("END:VCARD");
                out.newLine();
            }
        }
        catch(IOException e){
            System.err.println("Error: no se encuentra el archivo.");
        }
    }
    
    public static void copiaSeguridad(){
        
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("datos/copiaSeguridad.dat"))){
            out.writeObject(contactos);           
        }
        catch(IOException e){
            System.err.println("Error: no se encuentra el archivo");
        }
    }
    
    public static void restablecerCopiaSeguridad(){
        
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("datos/copiaSeguridad.dat"))){
           ArrayList<Contacto> copia = (ArrayList<Contacto>) in.readObject();
           
           Iterator<Contacto> it = copia.iterator();
           
           while(it.hasNext()){
               Contacto contacto = it.next();
               contactos.add(contacto);
           }
        }
        catch(IOException e){
            System.err.println("Error: el archivo no se ha encontrado");
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }
    
    public static void guardarContactos(){
        
        try(BufferedWriter out = new BufferedWriter(new FileWriter("datos/contactos.csv"))){
            
            out.write("Nombre,Apellidos,Telefono,Email");
            out.newLine();
            Iterator<Contacto> it = contactos.iterator();
           
           while(it.hasNext()){
               Contacto contacto = it.next();
               out.write(contacto.getNombre() + "," + contacto.getApellido() + "," + contacto.getTelefono() + "," + contacto.getEmail());
               out.newLine();
           }
            
        }
        catch(IOException e){
            System.err.println("Error: no se ha encontrado el archivo");
        }
    }
}
