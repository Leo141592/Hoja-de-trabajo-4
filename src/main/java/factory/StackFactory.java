package factory;

import stack.Stack;
import stack.ArrayListStack;
import stack.VectorStack;
import stack.ListStack;
import list.List;

public class StackFactory {

    public static <T> Stack<T> createStack(int option, List<T> list) {

        switch (option) {
            case 1:
                return new ArrayListStack<>();
            case 2:
                return new VectorStack<>();
            case 3:
                if (list == null) {
                    throw new IllegalArgumentException("List implementation required for ListStack");
                }
                return new ListStack<>(list);
            default:
                throw new IllegalArgumentException("Invalid stack option");
        }
    }
}