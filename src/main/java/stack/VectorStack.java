package stack;

import java.util.Vector;

public class VectorStack<T> extends AbstractStack<T> {

    private Vector<T> vector;

    public VectorStack() {
        vector = new Vector<>();
    }

    @Override
    public void push(T item) {
        vector.add(item);
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        T item = vector.remove(size - 1);
        size--;
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return vector.get(size - 1);
    }
}