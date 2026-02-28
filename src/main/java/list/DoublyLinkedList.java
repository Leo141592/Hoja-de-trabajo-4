package list;

public class DoublyLinkedList<T> extends AbstractList<T> {

    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        T data = head.data;

        if (head == tail) { // solo un elemento
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

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