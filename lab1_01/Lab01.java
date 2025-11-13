/**
    Простая программа с объявлением переменных
 */
public class Lab01 {
    public static void main(String arguments[]) {
        // Объявление переменной
        int varInt1;

        varInt1 = 100;
        int varInt2 = 0x64;
        int varInt3 = 0144;
        int varInt4 = 0b01100100;
        int varInt5 = 2_000_000_000;
        // Произвольный цвет ESC[38;2;R;G;Bm
        String RED = "\u001B[38;2;255;0;0m";
        System.out.println(RED);
        // Символ, изображающий закрашенный прямоугольник
        String RECTANGLE = "\u2588"; //0xDB;
        System.out.println(RECTANGLE);
        // Сброс к исходному состоянию консоли
        String RESET = "\u001B[0m";
        System.out.println(RESET);


        System.out.println("Результат операции 100 % 3 = " + (varInt1 % 3));

        System.out.println("Результат операции varInt5 * 2 = " + (varInt5 * 2L));

        boolean varBoolean1;
        varBoolean1 = true;

        boolean varBoolean2;
        varBoolean2 = false;

        System.out.println(varBoolean1 && varBoolean2);
        System.out.println(varBoolean1 || varBoolean2);
        System.out.println(!varBoolean1);
        System.out.println(varBoolean1 ^ varBoolean2);

    }
}