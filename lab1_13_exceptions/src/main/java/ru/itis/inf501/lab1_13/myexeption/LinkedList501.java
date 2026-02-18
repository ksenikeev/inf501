package ru.itis.inf501.lab1_13.myexeption;

public class LinkedList501 {

    private class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        public String toString() {
            return "" + value;
        }
    }

    private Node head;
    private int count;

    public void add(int value) {
        Node current = head;
        if (current == null) {
            head = new Node(value);
            count = 1;
            return;
        }
        for (int i = 0; i < count - 1; ++i) {
            current = current.next;
        }
        Node newNode = new Node(value);
        current.next = newNode;
        count++;
    }

    public void add(int value, int position) {
        Node current = head;
        for (int i = 0; i < position; ++i) {
            current = current.next;
        }
        Node temp = current.next;
        Node newNode = new Node(value);
        current.next = newNode;
        newNode.next = temp;
        count++;
    }

    public int get(int position) throws PositionException {
        if (position < 0 || position >= count) {
            throw new PositionException(position + " за границами списка");
        }
        Node current = head;
        for (int i = 0; i < position; ++i) {
            current = current.next;
        }
        return current.value;
    }

    public void remove(int position) throws PositionException {
        if (position < 0 || position >= count) {
            throw new PositionException(position + " за границами списка");
        }
        Node current = head;
        if (position != 0) {
            for (int i = 0; i < position - 1; ++i) {
                current = current.next;
            }
            Node temp = current.next;
            current.next = temp.next;
        }

        else {
            head = current.next;
        }
        count--;
    }


    public int compare(Node current, Node next) { return current.value - next.value;}

    public void swap(Node prev, Node current, Node next) {
        prev.next = next;
        current.next = next.next;
        next.next = current;
        if (current == head) head = next;
    }

    public void sort() {
        for (int i = 0; i < (count - 1); i++) {
            Node current = head;
            Node previous = head;
            Node next;
            for (int k = 0; k < (count - i) - 1; k++) {
                next = current.next;
                if (compare(current, next) > 0) {
                    swap(previous, current, next);
                    previous = next;
                } else {
                    previous = current;
                    current = next;
                }
            }
        }
    }

    public int pop() {
        Node current = head;
        for (int i = 0; i < count - 2; ++i) {
            current = current.next;
        }
        Node temp = current.next;
        int valuePoped = temp.value;
        current.next = null;
        count--;
        return valuePoped;
    }

    public int length() {
        return count;
    }

    public String toString() {
        String result = "";
        Node current = head;
        for (int i = 0; i < count; ++i) {
            result += current.value + " ";
            current = current.next;
        }
        return result;
    }
}