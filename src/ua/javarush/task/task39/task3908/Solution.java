package ua.javarush.task.task39.task3908;

/* 
Чи можливий паліндром?
*/

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("А роза упала на лапу Азора "));
    }

    public static boolean isPalindromePermutation(String s) {
        Set<Character> set = new HashSet<>();
        String cleanedString = cleanString(s);

        for (char c : cleanedString.toCharArray()) {
            if (!set.add(c)) {
                set.remove(c);
            }
        }

        return set.size() <= 1;
    }

    private static String cleanString(String s) {
        return s.trim().toLowerCase(Locale.ROOT).replace(" ", "");
    }
}