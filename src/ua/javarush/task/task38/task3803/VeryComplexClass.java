package ua.javarush.task.task38.task3803;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Runtime винятки (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object object = "new Object()";

        Integer integer = (Integer) object;
    }

    public void methodThrowsNullPointerException() {
        String testedString = null;

        System.out.println(testedString.length());
    }

    public static void main(String[] args) {
        VeryComplexClass veryComplexClass = new VeryComplexClass();

        veryComplexClass.methodThrowsClassCastException();
        veryComplexClass.methodThrowsNullPointerException();
    }
}
