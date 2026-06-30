package ua.javarush.task.task26.task2613;

import java.util.Map;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode) {
        if (currencyCode == null || currencyCode.length() < 3) {
            throw new IllegalArgumentException("Invalid currency code.");
        }

        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }
}
