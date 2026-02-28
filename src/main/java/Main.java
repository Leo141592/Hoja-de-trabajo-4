import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import converter.InfixToPostfixConverter;
import evaluator.PostfixEvaluator;
import stack.ArrayListStack;
import stack.Stack;

public class Main {

    public static void main(String[] args) {

        try {
            File file = new File("datos.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine().trim();

                // Saltar líneas vacías
                if (line.isEmpty()) {
                    continue;
                }

                // -------- INFIX → POSTFIX --------
                Stack<String> operatorStack = new ArrayListStack<>();
                InfixToPostfixConverter converter = new InfixToPostfixConverter(operatorStack);

                String postfix = converter.convert(line);

                // -------- POSTFIX EVALUATION --------
                Stack<Integer> valueStack = new ArrayListStack<>();
                PostfixEvaluator evaluator = new PostfixEvaluator(valueStack);

                int result = evaluator.evaluate(postfix);

                // -------- OUTPUT --------
                System.out.println("Infix: " + line);
                System.out.println("Postfix: " + postfix);
                System.out.println("Resultado: " + result);
                System.out.println("---------------------------");
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró el archivo datos.txt");
        } catch (Exception e) {
            System.out.println("Error al procesar la expresión: " + e.getMessage());
        }
    }
}