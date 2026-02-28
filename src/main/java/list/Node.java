package list;

class Node<T> {

    T data;
    Node<T> next;
    Node<T> prev; // solo lo usará la lista doble

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}