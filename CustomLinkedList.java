package module6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedList {

    private Node head;

    // Insert at end
    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Delete first occurrence
    public void delete(int data) {

        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }

            current = current.next;
        }
    }

    public Iterator<Integer> iterator() {
        return new LinkedListIterator();
    }

    private class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private class LinkedListIterator implements Iterator<Integer> {

        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            int data = current.data;
            current = current.next;

            return data;
        }
    }
}
