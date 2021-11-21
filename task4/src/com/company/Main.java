package com.company;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();
        in.close();

        Scanner scanner = new Scanner(new File(path));
        int count = 0;
        while (scanner.hasNextLine()) {
            count++;
            scanner.nextLine();
        }

        scanner = new Scanner(new File(path));
        int Nums[] = new int[count];
        for (int i = 0; i < Nums.length; i++) {
            Nums[i] = scanner.nextInt();
        }

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
                    System.out.println( Steps);
                    return;
                }
            }
        }
    }
}