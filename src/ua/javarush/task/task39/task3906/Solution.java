package ua.javarush.task.task39.task3906;

/* 
Інтерфейси нас врятують!
*/

public class Solution {
    public static void main(String[] args) {
        ElectricPowerSwitch electricPowerSwitch = new ElectricPowerSwitch(new SecuritySystem());

        electricPowerSwitch.press();
        electricPowerSwitch.press();
    }
}
