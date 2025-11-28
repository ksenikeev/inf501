package ru.itis.inf501.lab1_12.linkedlist;

public class LinkedListMain {
    public static void main(String[] args) {
        // Первый элемент, он же - голова связного списка
        Node head = new Node(10);

        Node element2 = new Node(3);
        // свяжем 2-й элемент с 1-м
        head.next = element2;

        Node element3 = new Node(4);
        // свяжем 2-й элемент с 1-м
        element2.next = element3;

        Node element4 = new Node(1);
        // свяжем 2-й элемент с 1-м
        element3.next = element4;

        Node element5 = new Node(7);
        // свяжем 2-й элемент с 1-м
        element4.next = element5;

        // Перебор всех элементов
        // Заводим переменную-указатель на текущий элемент,
        // начинаем с головы
        Node current = head;
/*
        while (current != null) {
         // выводим значение текущего элемента
         System.out.println(current.value);
         // двигаемся к следующему
         current = current.next;
        }
*/

        // вставляем в начало
        Node first = new Node(9);
        first.next = head;
        head = first;

 /*       current = head;
        while (current != null) {
            // выводим значение текущего элемента
            System.out.println(current.value);
            // двигаемся к следующему
            current = current.next;
        }
*/
        // вставляем в позицию 3,
        // т.е. новый элемент должен встать после 2-го (от 0)
        current = head;
        for (int i = 0; i < 2; ++i)
            current = current.next;
        Node p = new Node(18); // новый
        Node temp = current.next;   // сохраняем ссылку на 3-й
        current.next = p; // меняем ссылку 2-го элемента с 3-го на новый
        p.next = temp; // теперь новый элемент ссылается на "старый 3-й"

        current = head;
        while (current != null) {
            // выводим значение текущего элемента
            System.out.println(current.value);
            // двигаемся к следующему
            current = current.next;
        }

    }
}
