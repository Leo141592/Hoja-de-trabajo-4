package stack;

import list.List;

public class ListStack<T> extends AbstractStack<T> {

    private List<T> list;

    public ListStack(List<T> list) {
        this.list = list;
    }

    @Override
    public void push(T item) {
        list.addFirst(item);
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        size--;
        return list.removeFirst();
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return list.getFirst();
    }
}