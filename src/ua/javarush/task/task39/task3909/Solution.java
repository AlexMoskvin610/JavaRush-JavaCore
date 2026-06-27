package ua.javarush.task.task39.task3909;

/* 
Одна зміна
*/

import org.w3c.dom.ls.LSOutput;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isOneEditAway("qwerty", "qwerty678"));
    }

    public static boolean isOneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        // Определяем, какая строка короче, а какая длиннее
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0; // Указатель для короткой строки
        int index2 = 0; // Указатель для длинной строки
        boolean foundDifference = false;

        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                // Если мы уже находили одно различие раньше — значит правок больше, чем одна
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;

                if (s1.length() == s2.length()) {
                    // При замене (длины равны) двигаем указатель короткой строки вперед
                    index1++;
                }
                // При вставке/удалении указатель короткой строки (index1) оставляем на месте,
                // чтобы на следующем шаге снова сравнить текущий символ с новым символом из s2
            } else {
                // Если символы совпали, двигаем короткий указатель
                index1++;
            }
            // Длинный указатель двигаем в любом случае
            index2++;
        }

        return true;
    }
}
