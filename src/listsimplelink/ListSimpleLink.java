package listsimplelink;

import java.util.Scanner;
import controller.List;

public class ListSimpleLink {

    static Scanner scan = new Scanner(System.in);

    static List objList = new List();

    public static void main(String[] args) {
        insertHead();
        insertarAlFinal();
        eliminarNodo();
        iteratorTravel();
        triggerTravel();
        destroy();
    }

    private static void insertHead() {
        char opcInsert;

        System.out.println("Ingresando datos al Inicio de la Lista");

        do {
            System.out.println("Ingrese edad: ");
            int age = scan.nextInt();

            try {
                if (objList.insertList(age)) {
                    System.out.println("Edad ingresada correctamente....");
                } else {
                    System.out.println("Error al ingresar la edad, intentelo de nuevo");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            do {
                System.out.println("\nDesea ingresar una edad S para Si o N para No: ");
                opcInsert = scan.next().toUpperCase().charAt(0);
            } while (opcInsert != 'S' && opcInsert != 'N');
        } while (opcInsert == 'S');
    }

    private static void insertarAlFinal() {
        char opcInsert;
        System.out.println("\nIngresando datos al Final de la Lista");

        do {
            System.out.println("Ingrese edad: ");
            int age = scan.nextInt();

            try {
                if (objList.insertarAlFinal(age)) {
                    System.out.println("Edad ingresada correctamente al final....");
                } else {
                    System.out.println("Error al ingresar la edad, intentelo de nuevo");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            do {
                System.out.println("\nDesea ingresar otra edad S para Si o N para No: ");
                opcInsert = scan.next().toUpperCase().charAt(0);
            } while (opcInsert != 'S' && opcInsert != 'N');
        } while (opcInsert == 'S');
    }

    private static void eliminarNodo() {
        System.out.println("\nEliminar nodo por referencia");
        
        try {
            System.out.println("Ingrese la edad a eliminar: ");
            int edad = scan.nextInt();
            
            objList.eliminarNodo(edad);
            System.out.println("Operación de eliminación completada");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void iteratorTravel() {
        System.out.println("\nMostrar el contenido de la lista");
        try {
            byte count = 1;
            boolean first = true;
            int data = objList.iteratorTravel(first);
            while (data != 0) {
                System.out.println("El dato del " + count + " es : " + data);
                count++;
                first = false;
                data = objList.iteratorTravel(first);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void triggerTravel() {
        System.out.println("\nMostrando Datos de Forma Recursiva");
        boolean first = true;
        try {
            byte count = 1;
            int data = objList.iteratorTravel(first);
            recursiveTravel(data, count);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void recursiveTravel(int data, byte count) {
        if (data != 0) {
            System.out.println("El dato del nodo " + count + " es : " + data);
            count++;
            
            try {
                recursiveTravel(objList.iteratorTravel(false), count);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void destroy() {
        System.out.println("\nDestruyendo la lista");
        if ( objList.destroy() ) {
            System.out.println("La lista fue destruida!...");
            iteratorTravel();
        } else {
            System.out.println("La lista esta vacia!...");
        }
    }

}

