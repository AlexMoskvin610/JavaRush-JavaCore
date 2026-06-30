package ua.javarush.task.task26.task2613;

import java.util.HashMap;
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

    public void addAmount(int denomination, int count) {
        if (denominations == null) {
            denominations = new HashMap<>();
        }

        denominations.merge(denomination, count, Integer::sum);
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    @Override
    public String toString() {
        return "CurrencyManipulator{" +
                "currencyCode='" + currencyCode + '\'' +
                ", denominations=" + denominations +
                '}';
    }
}
