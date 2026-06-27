package ua.javarush.task.task39.task3907;

/* 
ISP
*/

import ua.javarush.task.task39.task3907.workers.LazyPerson;
import ua.javarush.task.task39.task3907.workers.NormalWorker;
import ua.javarush.task.task39.task3907.workers.RobotWorker;

public class Solution {
    public static void main(String[] args) {
        LazyPerson lazyPerson = new LazyPerson();
        NormalWorker normalWorker = new NormalWorker();
        RobotWorker robotWorker = new RobotWorker();

        lazyPerson.eat();
        lazyPerson.sleep();

        normalWorker.eat();
        normalWorker.sleep();
        normalWorker.work();

        robotWorker.work();
    }
}
