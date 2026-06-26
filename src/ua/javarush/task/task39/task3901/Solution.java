package ua.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 
Унікальні підрядки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        return findLongestUniqueSubstring(s);
    }

    //a123bcbcqwe
    private static int findLongestUniqueSubstring(String s) {
      Set<Character> characters = new HashSet<>();
      int maxLength = 0;
      int left = 0;

      for (int right = 0; right < s.length(); right++) {
          char currentchar = s.charAt(right);

          while (characters.contains(currentchar)) {
                characters.remove(s.charAt(left));
                left++;
          }

          characters.add(currentchar);

          maxLength = Math.max(maxLength, right - left + 1);
      }
        return maxLength;
    }
}
