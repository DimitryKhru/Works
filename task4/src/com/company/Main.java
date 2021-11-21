package com.company;
import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        int [] nums = {1, 10, 2, 9};
        int [] ComparedValue = new int[nums.length];
        int sum = Arrays.stream(nums).sum() / nums.length;
        for (int l = 0; l < nums.length; l++){
            ComparedValue[l] = sum;
        }
        int path = 0;
        while (true)
            for (int i = 0; i < nums.length; i++){
                if (nums[i] < sum){
                    nums[i] += 1;
                    path += 1;
                } else if (nums[i] > sum){
                    nums[i] -= 1;
                    path += 1;
                } else if (Arrays.equals(nums, ComparedValue)){
                    System.out.println(path);
                    return;
                }
            }
        }
    }

