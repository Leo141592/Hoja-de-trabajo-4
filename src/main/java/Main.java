import java.util.Scanner;

import stack.Stack;
import factory.StackFactory;
import factory.ListFactory;
import list.List;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Selección de Implementación de Stack ===");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista");
        System.out.print("Seleccione una opción: ");

        int stackOption = scanner.nextInt();

        Stack<Integer> stack = null;
        List<Integer> list = null;

        if (stackOption == 3) {
            System.out.println("\n=== Selección de Implementación de Lista ===");
            System.out.println("1. Simplemente Encadenada");
            System.out.println("2. Doblemente Encadenada");
            System.out.print("Seleccione una opción: ");

            int listOption = scanner.nextInt();

            list = ListFactory.createList(listOption);
        }

        stack = StackFactory.createStack(stackOption, list);

        System.out.println("\nStack creado exitosamente.");

        // Prueba rápida para verificar funcionamiento
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Elemento en el tope: " + stack.peek());
        System.out.println("Elemento removido: " + stack.pop());
        System.out.println("Nuevo tope: " + stack.peek());
        System.out.println("Tamaño actual: " + stack.size());

        scanner.close();
    }
}