package ua.javarush.task.task38.task3809;

/* 
Annotation + Reflection
*/

public class Solution {
    public static void main(String[] args) throws IllegalAccessException {
        JavaRushBankAccount account = new JavaRushBankAccount("Mr.Smith");

        System.out.println("Перевірка №1:");
        ReflectionAnnotationUtil.check(account);

        System.out.println("Перевірка №2:");
        account.setAmount(100);
        ReflectionAnnotationUtil.check(account);

        System.out.println("Перевірка №3:");
        ReflectionAnnotationUtil.check(new IncorrectAccount());
/* Очікуваний вивід:

Перевірка №1:
Поле amount в класі JavaRushBankAccount має анотацію LongPositive, але його значення не додатнє.
Перевірка №2:
Перевірка №3:
Поле amountString в класі IncorrectAccount має анотацію LongPositive, але його тип String.

*/
    }
}
