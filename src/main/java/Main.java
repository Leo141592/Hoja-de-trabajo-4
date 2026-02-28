import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import converter.InfixToPostfixConverter;
import evaluator.PostfixEvaluator;
import stack.Stack;
import factory.StackFactory;
import list.List;
import factory.ListFactory;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("===== SELECCIONAR IMPLEMENTACION DE STACK =====");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista");

        System.out.print("Ingrese opcion: ");
        int stackOption = input.nextInt();

        int listOption = 0;

        // Si eligió lista, pedir implementación de lista
        if (stackOption == 3) {
            System.out.println("\n===== SELECCIONAR IMPLEMENTACION DE LISTA =====");
            System.out.println("1. Simplemente encadenada");
            System.out.println("2. Doblemente encadenada");
            System.out.print("Ingrese opcion: ");
            listOption = input.nextInt();
        }

        input.close();

        // Procesar expresiones en datos.txt
        try {
            File file = new File("datos.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty())
                    continue;

                // -------- CONVERSIÓN INFIX → POSTFIX --------
                Stack<String> operatorStack;

                if (stackOption == 3) {
                    // Crear lista para conversión
                    List<String> listForConversion = ListFactory.createList(listOption);
                    operatorStack = StackFactory.createStack(stackOption, listForConversion);
                } else {
                    operatorStack = StackFactory.createStack(stackOption, null);
                }

                InfixToPostfixConverter converter = new InfixToPostfixConverter(operatorStack);

                String postfix = converter.convert(line);

                // -------- EVALUACIÓN POSTFIX --------
                Stack<Integer> valueStack;

                if (stackOption == 3) {
                    // Crear lista para evaluación
                    List<Integer> listForEvaluation = ListFactory.createList(listOption);
                    valueStack = StackFactory.createStack(stackOption, listForEvaluation);
                } else {
                    valueStack = StackFactory.createStack(stackOption, null);
                }

                PostfixEvaluator evaluator = new PostfixEvaluator(valueStack);

                int result = evaluator.evaluate(postfix);

                // -------- IMPRIMIR RESULTADOS --------
                System.out.println("Infix:    " + line);
                System.out.println("Postfix:  " + postfix);
                System.out.println("Resultado: " + result);
                System.out.println("----------------------------------");
            }

            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró el archivo datos.txt");
        }
    }
}