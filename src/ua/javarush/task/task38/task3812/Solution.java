package ua.javarush.task.task38.task3812;

/* 
Обробка анотацій
*/

import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        System.out.println(printFullyQualifiedNames(Solution.class));
        System.out.println(printFullyQualifiedNames(SomeTest.class));

        System.out.println(printValues(Solution.class));
        System.out.println(printValues(SomeTest.class));
    }

    public static boolean printFullyQualifiedNames(Class c) {
        if (c == null || !c.isAnnotationPresent(PrepareMyTest.class)) {
            return false;
        }

        PrepareMyTest annotation = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
        String[] names = annotation.fullyQualifiedNames();

        Stream.of(names).forEach(System.out::println);

        return true;
    }

    public static boolean printValues(Class c) {
        if (c == null || !c.isAnnotationPresent(PrepareMyTest.class)) {
            return false;
        }

        PrepareMyTest annotation = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
        Class[] names = annotation.value();

        for (Class clazz : names) {
            System.out.println(clazz.getSimpleName());
        }

        return true;
    }
}