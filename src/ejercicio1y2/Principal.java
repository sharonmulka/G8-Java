/*
Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String.
El programa pedirá una raza de perro en un bucle, el mismo se guardará en la lista y
después se le preguntará al usuario si quiere guardar otro perro o si quiere salir. Si
decide salir, se mostrará todos los perros guardados en el ArrayList.
*/
package ejercicio1y2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        ArrayList<String> razasPerros = new ArrayList<>();
        String perros;
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        String opcion;
        boolean seguir = true;

        System.out.println("EJERCICIO 1");

        do {
            System.out.println("Inserte nombres de razas de perros: ");
            perros = leer.next();
            razasPerros.add(perros);
            
            
            System.out.println("Desea agregar otra raza de perro? Presione S/N");
            do {
                opcion = leer.next();
                if (("N").equalsIgnoreCase(opcion)) {
                    System.out.println("Usted ha salido del programa.");
                    seguir = false;
                } else if (!("S").equalsIgnoreCase(opcion)) {
                    System.out.println("Ingrese una opcion válida, S/N.");
                }
            } while (!("N").equalsIgnoreCase(opcion) && !("S").equalsIgnoreCase(opcion));

        } while (seguir);

        for (String perritos : razasPerros) {
            System.out.println(perritos);
        }

/*
Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le
pedirá un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista.
Si el perro está en la lista, se eliminará el perro que ingresó el usuario y se mostrará
la lista ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y
se mostrará la lista ordenada.
*/
        System.out.println("EJERCICIO 2");
        String buscarPerro = new String();
        System.out.print("Ingrese una raza de perro a eliminar: ");
        buscarPerro = leer.next();
        boolean eliminado = false;

        Iterator<String> it = razasPerros.iterator();

        while (it.hasNext()) {
            if (it.next().equals(buscarPerro)) {
                it.remove();
                eliminado = true;
            }
        }
        
        if (eliminado) {
            System.out.println("Se ha eliminado un elemento de la lista.");
        } else {
            System.out.println("No se ha encontrado el elemento.");
        }
        
        Collections.sort(razasPerros);
        
        for (String perritos : razasPerros) {

                System.out.println(perritos);
            }
            

    }
}
