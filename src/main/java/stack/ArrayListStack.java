package stack;

import java.util.ArrayList;

public class ArrayListStack<T> extends AbstractStack<T> {

    private ArrayList<T> list;

    public ArrayListStack() {
        list = new ArrayList<>();
    }

    @Override
    public void push(T item) {
        list.add(item);
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        T item = list.remove(size - 1);
        size--;
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return list.get(size - 1);
    }
}