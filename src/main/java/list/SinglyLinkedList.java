package list;

public class SinglyLinkedList<T> extends AbstractList<T> {

    private Node<T> head;

    public SinglyLinkedList() {
        head = null;
    }

    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        return head.data;
    }
}