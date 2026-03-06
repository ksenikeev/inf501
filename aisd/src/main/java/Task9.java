import java.util.Arrays;
import java.util.Comparator;

/**
 * Дан список неотрицательных чисел. Измените их порядок так, ч
 * тобы если их после этого выписать в строку, то получилось максимальное из возможных чисел.
 * Пример: дан массив [3, 30, 34, 5, 9]. Максимальное возможное число можно получить 9534330.
 */

public class Task9 {
    public static void main(String[] args) {
        int[] a = {301, 234, 342, 511, 987, 989};

        int k = 1;
        for (int  n = 0; n < 3; ++n) {
            int c[] = new int[10];


            for (int i = 0; i < a.length; ++i) c[(a[i] / k) % 10] += 1;

            int d[] = new int[10];
            d[9] = 0;
            for (int i = 8; i >= 0; --i) d[i] = d[i + 1] + c[i + 1];

            int[] b = new int[a.length];


            for (int i = 0; i < a.length; ++i) {
                b[d[(a[i] / k) % 10]] = a[i];
                d[(a[i] / k) % 10] += 1;
            }
            k *= 10;
            a = b;
        }
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + " ");
        }
        // 301 511 342 234 989



/*
        String[] m = new String[a.length];
        // O(n * log (max(a)))
        for (int i = 0; i < a.length; ++i) {
            m[i] = String.valueOf(a[i]);
        }

        int r = 0;
        Arrays.sort(m, new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (r > o1.length() - 1 && r > o2.length() - 1) return 0;
                if (r > o1.length() && r == o2.length())
                return o2.charAt(r) - o1.charAt(r);
            }
        });


        for (String i : m) {
            System.out.print(i);
        }

*/
    }
}
