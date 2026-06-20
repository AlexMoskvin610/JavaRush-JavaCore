package ua.javarush.task.task38.task3804;

/* 
Фабрика винятків
*/

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Solution {
    public static Class getFactoryClass() {
        return new ExceptionFactory().getClass();
    }

    public static void main(String[] args) throws Throwable {
            throw ExceptionFactory.getException(null);
    }
}
