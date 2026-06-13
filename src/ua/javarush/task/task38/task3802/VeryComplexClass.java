package ua.javarush.task.task38.task3802;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

/*
Перевірені винятки (checked exception)
*/
public class VeryComplexClass {
    public void veryComplexMethod() throws  Exception {
        BufferedReader reader =
                new BufferedReader(new FileReader("c:/file.txt"));
    }

    public static void main(String[] args) {
        VeryComplexClass veryComplexClass = new VeryComplexClass();

        try {
            veryComplexClass.veryComplexMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
