import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Julio Cesar Santaman Cruz.
 */

// Interfaz utilizada para las clases anónimas.
interface AnnonClass {

    public void sort();
}

// Interfaz utilizada para ordenar alfabéticamente.
interface SortAlphabetically {
    public void sort(List list);
}

// Interfaz utilizada para ordenar por longitud.
interface SortByLongitude {
    public void sortByLongitude(List list, Comparator<String> comparator);
}

// Interfaz utilizada para imprimir una lista.
interface Print {

    public void print(List list);
}

// Clase con métodos de ordenamiento.
class SortList {

    // Métodos de la clase.
    public static void sort(List list) {
        Collections.sort(list);
    }

    public static void sort(List list, Comparator<String> comparator) {
        Collections.sort(list, comparator);
    }

}

// Clase principal.
public class Sorting {

    // Atributos.
    private static final List<String> myList = new ArrayList<>(Arrays.asList("hola", "palabra", "comida", "pelicula", "celular", "casa", "libro", "agua", "refresco", "playera"));

    public static void main(String[] args) {

        System.out.println("Ordenamientos de palabras");
        
        // Expresión lambda para imprimir una lista.
        Print print = (list) -> {
            list.forEach(word -> {
                System.out.println(word);
            });
            System.out.println();
        };
        
        // Comparador que ayuda a ordenar una lista por longitud.
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int str0 = o1.length();
                int str1 = o2.length();

                return str0 < str1 ? -1 : str0 > str1 ? 1 : 0;
            }
        };
        
        // Cantidad de elementos en la lista.
        System.out.println("Hay " + myList.size() + " elementos en la lista.");

        // a. Por longitud utilizando clase anónima. 
        AnnonClass anonymous = new AnnonClass() {
            @Override
            public void sort() {
                Collections.sort(myList, comparator);
                System.out.println("a. Por longitud utilizando clase anónima.");
                print.print(myList);
            }
        };

        // a.
        anonymous.sort();

        // b. Por longitud utilizando expresión lambda. 
        SortByLongitude sortByLongitude2 = (list, c) -> Collections.sort(list, c);
        sortByLongitude2.sortByLongitude(myList, comparator);
        System.out.println("b. Por longitud utilizando expresión lambda.");
        print.print(myList);

        // c. Por longitud utilizando método de referencia.
        SortByLongitude sortByLongitude3 = SortList::sort;
        sortByLongitude3.sortByLongitude(myList, comparator);
        System.out.println("c. Por longitud utilizando método de referencia.");
        print.print(myList);
        
        // d. Por orden alfabético utilizando clase anónima. 
        AnnonClass anonymous2 = new AnnonClass() {
            @Override
            public void sort() {
                Collections.sort(myList);
                System.out.println("d. Por orden alfabético utilizando clase anónima.");
                print.print(myList);
            }
        };

        // d.
        anonymous2.sort();

        // e. Por orden alfabético utilizando expresión Lambda. 
        SortAlphabetically sortAlphabetically2 = (list) -> Collections.sort(list);
        sortAlphabetically2.sort(myList);
        System.out.println("e. Por orden alfabético utilizando expresión Lambda.");
        print.print(myList);

        // f. Por orden alfabético utilizando método de referencia.
        SortAlphabetically sortAlphabetically3 = SortList::sort;
        sortAlphabetically3.sort(myList);
        System.out.println("f. Por orden alfabético utilizando método de referencia.");
        print.print(myList);

    }
}
