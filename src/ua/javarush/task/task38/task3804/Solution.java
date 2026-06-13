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

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
       String fullClassName = getFactoryClass().getName(); // "com.example.MyFactory"

        try {
            // 1. Загружаем класс по полной строке
            Class<?> loadedClass = Class.forName(fullClassName);
            // 2. Находим статический метод
            Method method = loadedClass.getMethod("getException", Enum.class);
            Throwable resultException = (Throwable) method.invoke(null, ApplicationExceptionMessage.UNHANDLED_EXCEPTION);
            // Теперь у тебя в руках готовый Throwable объект, созданный динамически!
            System.out.println("Исключение успешно создано: " + resultException.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
