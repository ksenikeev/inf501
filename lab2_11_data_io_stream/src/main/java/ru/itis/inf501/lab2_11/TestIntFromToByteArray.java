package ru.itis.inf501.lab2_11;

public class TestIntFromToByteArray {
    public static void main(String[] args) {
        int x = 0b00000011_01010001_11010110_10001001;
        // 0xFF = 00000000_00000000_00000000_11111111
        //                 00000011_01010001_11010110_10001001
        byte[] a = new byte[4];
        a[3] = (byte) (x & 0xFF);
        a[2] = (byte) ((x >> 8) & 0xFF);
        a[1] = (byte) ((x >> 16) & 0xFF);
        a[0] = (byte) ((x >> 24) & 0xFF);

           x = 0b00000011_01010001_11010110_10001001;
        // i  =  00000000_00000000_00000000_10001001
//                     11_01010001_11010110_10001001

/*
        int i = a[3] & 0xFF ;
        i = i | (a[2] & 0xFF) << 8;
        i = i | (a[1] & 0xFF) << 16;
        i = i | (a[0] & 0xFF) << 24;
*/

        int i = (a[3] & 0xFF) | ((a[2] & 0xFF) << 8) | ((a[1] & 0xFF) << 16) | ((a[0] & 0xFF) << 24);
        System.out.println(Integer.toBinaryString(i));

        a = IntFromToByteArray.int2byteArray(123345);

        i = IntFromToByteArray.intFromByteArray(a);
        System.out.println(i);
    }
}
