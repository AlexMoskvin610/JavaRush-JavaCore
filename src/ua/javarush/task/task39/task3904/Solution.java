package ua.javarush.task.task39.task3904;

/*
Сходи
*/

public class Solution {
    private static int n = 70;

    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;

        long[] dp = new long[n + 1];
        dp[0] = 1; // Базовый случай

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1]; // Прыжок на 1
            if (i >= 2) dp[i] += dp[i - 2]; // Прыжок на 2
            if (i >= 3) dp[i] += dp[i - 3]; // Прыжок на 3
        }

        return dp[n];
    }
}


