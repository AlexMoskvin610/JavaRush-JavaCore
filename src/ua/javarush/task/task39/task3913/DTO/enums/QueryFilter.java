package ua.javarush.task.task39.task3913.DTO.enums;

public enum QueryFilter {
    IP("ip"),
    USER("user"),
    DATE("date"),
    EVENT("event"),
    STATUS("status"),
    TASK_NUMBER("task_number");

    private final String code;

    QueryFilter(String code) {
        this.code = code;
    }

    public static QueryFilter fromString(String text) {
        for (QueryFilter type : values()) {
            if (type.code.equalsIgnoreCase(text))

                return type;
        }
        throw new IllegalArgumentException("Unknown query filter: " + text);
    }
}
