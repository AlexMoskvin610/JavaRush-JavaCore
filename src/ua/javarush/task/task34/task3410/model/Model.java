package ua.javarush.task.task34.task3410.model;

import ua.javarush.task.task34.task3410.controller.EventListener;

public class Model {
    public static final int FIELD_CELL_SIZE = 20;

    private EventListener eventListener;

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }
}
