package factory;

import list.List;
import list.SinglyLinkedList;
import list.DoublyLinkedList;

public class ListFactory {

    public static <T> List<T> createList(int option) {

        switch (option) {
            case 1:
                return new SinglyLinkedList<>();
            case 2:
                return new DoublyLinkedList<>();
            default:
                throw new IllegalArgumentException("Invalid list option");
        }
    }
}