package ua.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(1));
    }

    public static boolean isPowerOfThree(int n) {
        long multiplier = 1;

        while (multiplier < n) {
            multiplier *= 3;
        }

        return multiplier == n;
    }
}
