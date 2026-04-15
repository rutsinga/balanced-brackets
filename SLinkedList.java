
import java.util.NoSuchElementException;

public class SLinkedList<T> {

    class Node {
        T data;
        Node next;
        Node(T data) {
            this.data = data;
            next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public SLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(T data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        T data = head.data;
        head = head.next;
        size--;
        if (head == null) {
            tail = null;
        }
        return data;
    }

    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        if (head.next == null) {
            T data = head.data;
            head = null;
            tail = null;
            size--;
            return data;
        }
        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        T data = tail.data;
        current.next = null;
        tail = current;
        size--;
        return data;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean contains(T data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        return head.data;
    }

    public T getLast() {
        if (tail == null) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.data;
    }

    public void remove(T e) {
        if (head == null) return;

        if (head.data.equals(e)) {
            head = head.next;
            if (head == null) tail = null;
            size--;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(e)) {
                if (current.next == tail) tail = current;
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        tail = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void deleteConsecutiveDuplicates() {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data.equals(current.next.data)) {
                current.next = current.next.next;
                if (current.next == null) tail = current;
                size--;
            } else {
                current = current.next;
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SLinkedList)) return false;

        SLinkedList<?> other = (SLinkedList<?>) obj;
        if (this.size != other.size) return false;

        Node current = this.head;
        SLinkedList<?>.Node otherCurrent = other.head;
        while (current != null) {
            if (!current.data.equals(otherCurrent.data)) return false;
            current = current.next;
            otherCurrent = otherCurrent.next;
        }
        return true;
    }
}