package ua.javarush.task.task39.task3913.DTO.enums;

public enum QueryType {
    GET("get"),
    POST("post"),
    PUT("put"),
    DELETE("delete");

    private final String code;

    QueryType(String code) {
        this.code = code;
    }

    public static QueryType fromString(String text) {
        for (QueryType type : values()) {
            if (type.code.equalsIgnoreCase(text))

                return type;
        }
        throw new IllegalArgumentException("Unknown query type: " + text);
    }
}
