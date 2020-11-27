package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount() {
        int result = 0;
        for (Map.Entry entry : denominations.entrySet()) {
            result += (int) entry.getKey() * (int) entry.getValue();
        }
        return result;
    }

    public boolean hasMoney() {
        return getTotalAmount() > 0;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return expectedAmount <= getTotalAmount();
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        int sum = expectedAmount;
        HashMap<Integer, Integer> temp = new HashMap<>();
        temp.putAll(denominations);
        ArrayList<Integer> nominals = new ArrayList<>();
            for (Map.Entry<Integer, Integer> pair : temp.entrySet())
                nominals.add(pair.getKey());

        Collections.sort(nominals);
        Collections.reverse(nominals);

        TreeMap<Integer, Integer> result = new TreeMap<>(//Collections.reverseOrder());
                    new Comparator<Integer>()
                    {
                        @Override
                        public int compare(Integer o1, Integer o2)
                        {
                            return o2.compareTo(o1);
                        }
                    });

        for (Integer nominal : nominals) {
            int key = nominal;
            int value = temp.get(key);
            while (true) {
                if (sum < key || value <= 0) {
                    temp.put(key, value);
                    break;
                }
                sum -= key;
                value--;

                if (result.containsKey(key))
                    result.put(key, result.get(key) + 1);
                else
                    result.put(key, 1);
            }
        }

        if (sum > 0)
            throw new NotEnoughMoneyException();
        else {
            denominations.clear();
            denominations.putAll(temp);
        }
        return result;

        /*
        ArrayList<Integer> denominationList = new ArrayList<>(denominations.keySet());
        Collections.sort(denominationList);
        Collections.reverse(denominationList);
        Map<Integer, Integer> result = new TreeMap<>(Collections.reverseOrder());
        for (Integer denomination : denominationList) {
            if (expectedAmount < denomination) {
                break;
            }
            int amount = expectedAmount / denomination;
            if (amount > denominations.get(denomination)) {
                amount = denominations.get(denomination);
            }
            result.put(denomination, amount);
            if ((denomination * amount) == expectedAmount ) {
                break;
            } else {
                expectedAmount -= denomination * amount;
            }
        }
        if (expectedAmount != 0) {
            System.out.println("!");
            throw new NotEnoughMoneyException();
        }
        System.out.println(result.toString());
        return result;

         */
    }
}
