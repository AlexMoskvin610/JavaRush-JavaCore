package ua.javarush.task.task26.task2613;

import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CurrencyManipulatorFactory {
    private CurrencyManipulatorFactory() {}

    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        String codeUpper = currencyCode.toUpperCase(Locale.ROOT);

        return map.computeIfAbsent(codeUpper, k -> new CurrencyManipulator(codeUpper));
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return map.values();
    }
}
