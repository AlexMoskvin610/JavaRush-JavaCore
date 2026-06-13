package ua.javarush.task.task38.task3801;

/* 
Виправ помилки в коді
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                System.out.println("Ім'я містить " + NameChecker.getNumberOfCharacters(args[0]) + " символів");
            } catch (NameIsNullException e) {
                System.out.println("Помилка: Ім'я не задане");
            } catch (NameIsEmptyException e) {
                System.out.println("Помилка: Ім'я порожнє");
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}