package ru.itis.inf501.lab1_13.myexeption;

public class MainExceptionList {
    public static void main(String[] args) {

        LinkedList501 list = new LinkedList501();

        list.add(1);
        list.add(3);
        list.add(5);

        System.out.println(list);

        try {
            System.out.println(
                    list.get(10));


        } catch (PositionException e) {
            e.printStackTrace();
        }


    }
}
