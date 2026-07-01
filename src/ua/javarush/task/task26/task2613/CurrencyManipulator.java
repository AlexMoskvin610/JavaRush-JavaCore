package ua.javarush.task.task26.task2613;

import ua.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        if (currencyCode == null || currencyCode.length() < 3) {
            throw new IllegalArgumentException("Invalid currency code.");
        }

        this.currencyCode = currencyCode;
    }

    public void addAmount(int denomination, int count) {
        denominations.merge(denomination, count, Integer::sum);
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public int getTotalAmount() {
        int total = 0;

        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            total += entry.getKey() * entry.getValue();
        }

        return total;
    }

    public boolean hasMoney(){
        return !denominations.isEmpty();
    }

    @Override
    public String toString() {
        return "CurrencyManipulator{" +
                "currencyCode='" + currencyCode + '\'' +
                ", denominations=" + denominations +
                '}';
    }

    public Map<Integer, Integer> withdrawAmount(int amount) throws NotEnoughMoneyException {
        Map<Integer, Integer> moneyToDispense = new TreeMap<>(Comparator.reverseOrder());

        List<Integer> nominals = denominations.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int remainingAmount = amount;

        for (Integer nominal : nominals) {
            int availableBanknotes = denominations.get(nominal); // Сколько купюр есть в банкомате
            int neededBanknotes = remainingAmount / nominal;     // Сколько купюр этого номинала влезет в остаток суммы

            // Берем минимум из того, что нужно, и того, что есть в наличии
            int banknotesToTake = Math.min(availableBanknotes, neededBanknotes);

            if (banknotesToTake > 0) {
                moneyToDispense.put(nominal, banknotesToTake);
                remainingAmount -= nominal * banknotesToTake; // Уменьшаем оставшуюся сумму
            }

            // Если собрали всю сумму, можно прервать цикл
            if (remainingAmount == 0) {
                break;
            }
        }

        if (remainingAmount > 0) {
            // В JavaRush тут обычно требуется выбросить кастомное исключение, например:
             throw new NotEnoughMoneyException();
        }

        // ВАЖНО: Если дошли сюда, значит сумма успешно собрана.
        // Теперь нужно списать выданные банкноты из баланса самого банкомата (мапы denominations)
        for (Map.Entry<Integer, Integer> entry : moneyToDispense.entrySet()) {
            int nominal = entry.getKey();
            int countToWithdraw = entry.getValue();
            int newCount = denominations.get(nominal) - countToWithdraw;

            if (newCount == 0) {
                denominations.remove(nominal); // Если купюры закончились, удаляем номинал
            } else {
                denominations.put(nominal, newCount); // Иначе обновляем количество
            }
        }

        return moneyToDispense;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() >= expectedAmount;
    }
}
