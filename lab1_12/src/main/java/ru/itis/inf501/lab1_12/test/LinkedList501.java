package ru.itis.inf501.lab1_12.test;

public class LinkedList501 {
    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public String toString() {
            return String.valueOf(value);
        }
        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head;
    private int count;

    //1. метод void add(int value), добавляет в конец связного списка новый элемент
    public void add(int value) {
        Node element = new Node(value);
        if (head == null) {
            head = element;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.setNext(element);
        }
        count++;
    }

    //2. метод void add(int value,  int position) - добавляет элемент в указанную позицию
    public void add(int value, int position) {
        Node element = new Node(value);//новый элемент
        Node current = head;
        for (int i = 0; i < (position--); ++i) {
            current = current.next;
        }
        Node temp = current.next;//сохраняем ссылку на 3-й элемент
        current.next = element;//меняем ссылку 2-го элемента с 3-го на новый
        element.next = temp;//теперь новый элемент ссылается на "старый 3-й"
        count++;
    }

    //3. метод int get(int position) - вернуть значение на позиции position (от 0)
    public int get(int position) {
        Node current = head;
        for (int i = 0; i < position; ++i) {
            current = current.next;
        }
        return current.getValue();
    }

    //4. метод int remove(int position) - удалить элемент на позиции position и вернуть его значение (с 0)
    public int remove(int position) {
        Node current = head;
        Node deleted;
        if (position == 0) {
            deleted = head;
            head = current.next;
        } else {
            for (int i = 0; i < (position - 1); ++i) {//
                current = current.next;
//                System.out.println("current " + current.value);
            }
//            System.out.println("last current " + current.value);
            deleted = current.next;
//            System.out.println("deleted " + deleted.value);
            Node temp = current.next.next;
            current.next = temp;
        }
        count--;
        return deleted.getValue();
    }

    //5. метод int pop() - удалить последний элемент и вернуть его значение
    public int pop() {
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        int deleted = current.next.value;
        current.next = null;
        count--;
        return deleted;
    }

    //6. метод int length() - вернуть кол-во элементов в связном списке
    public int length() {
        return count;
    }

    public void sort() {
        for (int i = 0; i < (count - 1); i++) {
            Node current = head;
            Node previous = head;
            Node next;
            for (int k = 0; k < (count - i - 1); k++) {
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

    public int compare(Node current, Node next) { return current.value - next.value;}

    public void swap(Node prev, Node current, Node next) {
        prev.next = next;
        current.next = next.next;
        next.next = current;
        if (current == head) head = next;
    }

    public String toString() {
        String result = "[";
        Node current = head;

        while (current != null) {
            result += current.value;
            if (current.next != null) {
                result += ", ";
            }
            current = current.next;
        };
        return result + "]";
    }
}



/*
    //3. метод int get(int position) - вернуть значение на позиции position
    public String getValueOnPosition(int position) {
        Node current = head;
        for (int i = 1; i < position; ++i) {
            if (current.next == null) {
                return "Такой позиции не существует";
            }
            current = current.next;
        }
        return "" + current.getValue();
    }
 */



/*
public int remove(int position) {
        Node current = head;
        if (position == 0) {
            head = current.next;
        } else {
            for (int i = 0; i < position--; ++i) {
                current = current.next;
            }
            Node temp = current.next.next;//сохраняем ссылку на 3-й элемент
            current.next = temp;//меняем ссылку 2-го элемента с 3-го на новый
        }
        return current.getValue();
    }
 */