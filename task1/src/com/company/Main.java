package com.company;
import java.util.Arrays;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] Array = new int[n];
        for (int i = 0; i < Array.length; i++) {
            Array[i] = i + 1;
        }
        System.out.println("Круговой массив: " + Arrays.toString(Array));

        int firstElement = 1;
        int nextfirstElement = 0;
        String path = String.valueOf(firstElement);

        while (true)
        {
//записываем, какой элемент будет первым в следующий раз
            nextfirstElement = Array[m - 1];

//проверяем, не пора ли заканчивать
            if (firstElement == nextfirstElement) {
                System.out.println("Путь: " + path);
                break;
            } else {
//запись пути
                path += Array[m - 1];
//круговой сдвиг влево на m
                int[] temp1Array = Arrays.copyOfRange(Array, m - 1, Array.length);
                int[] temp2Array = Arrays.copyOfRange(Array, 0, m - 1);


                for (int i = 0; i < temp1Array.length; i++) {
                    Array[i] = temp1Array[i];
                }
                for (int i = 0; i < temp2Array.length; i++) {
                    Array[temp1Array.length + i] = temp2Array[i];
                }

                System.out.println("Новый круговой массив: " + Arrays.toString(Array));
            }
        }
    }
}
