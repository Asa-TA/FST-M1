package Activities;

import java.util.*;

public class Activity2 {
    public static void main(String[] args) {
    
        int[] a = {10, 77, 10, 54, -11, 10};
        System.out.println("Original Array: " + Arrays.toString(a));
        
        int ina = 10;
        int checkina = 30;

      
        System.out.println("Result: " + result(a, ina, checkina));
    }

    public static boolean result(int[] a, int ina, int checkina) {
        int temp = 0;
      
        for (int N : a) {
        
            if (N == ina) {
                temp = temp + ina;
            }

            if (temp > checkina) {
                break;
            }
        }

        return temp == checkina;
    }
}