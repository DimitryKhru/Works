package com.company;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        String path = "C:\\Users\\DimaK\\OneDrive\\Рабочий стол\\Work2\\task4\\Num.txt";
        File file = new File(path);
        System.out.println(path);
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        String [] numString = line.split(" ");
        int Nums[] = new int[numString.length];

        for( int k = 0; k < numString.length; k++){
            Nums[k] = Integer.parseInt(numString[k]);
        }

        System.out.println("Изначальный массив: " + Arrays.toString(Nums));
        int[] ComparedValue = new int[Nums.length];
        int sum = Arrays.stream(Nums).sum() / Nums.length;

        int Steps;
        for(Steps = 0; Steps < Nums.length; ++Steps) {
            ComparedValue[Steps] = sum;
        }

        Steps = 0;

        while(true) {
            for(int i = 0; i < Nums.length; ++i) {
                if (Nums[i] < sum) {
                    Nums[i]++;
                    ++Steps;
                } else if (Nums[i] > sum) {
                    Nums[i]--;
                    ++Steps;
                } else if (Arrays.equals(Nums, ComparedValue)) {
                    System.out.println("Итог: " + Arrays.toString(Nums));
                    System.out.println( Steps);
                    return;
                }
            }
        }
    }
}