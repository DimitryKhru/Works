package com.company;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //Первый файл
//        System.out.println("файл 1");
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();

        Scanner file = new Scanner(new File(path));

        String line = file.nextLine();
        float x = Float.parseFloat(line.split(" ")[0]);
        float y = Float.parseFloat(line.split(" ")[1]);
        float r = Float.parseFloat(file.nextLine());

// System.out.println("Координаты центра окружности(x,y) : ("+x+","+y+")");
// System.out.println("Радиус окружности r = "+r);

        //Второй файл
        path = in.nextLine();
        in.close();

        file = new Scanner(new File(path));

        //считаем количество строк в документе
        int count = 0;
        while (file.hasNextLine()) {
            count++;
            file.nextLine();
        }

        //заполняем массив точек
        float[][] points = new float[count][2];

        file = new Scanner(new File(path));

        for (int i = 0; i < count; i++) {
            line = file.nextLine();
            points[i][0] = Float.parseFloat(line.split(" ")[0]);
            points[i][1] = Float.parseFloat(line.split(" ")[1]);
            // System.out.println(points[i][0]+" "+points[i][1]);
        }


        for (int i = 0; i < points.length; i++) {

            //на окружности
            if ((Math.pow(points[i][0] - x, 2) + Math.pow(points[i][1] - y, 2)) == Math.pow(r, 2))
                System.out.println("0");

                //внутри
            else if ((Math.pow(points[i][0] - x, 2) + Math.pow(points[i][1] - y, 2)) < Math.pow(r, 2))
                System.out.println("1");

                //вне
            else
                System.out.println("2");
        }
        // System.out.println("Массив точек: " + Arrays.toString(points));
    }
}