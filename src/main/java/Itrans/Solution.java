package Itrans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    class Transaction {
        String name;
        Integer time;
        Integer amount;
        String city;
        public Transaction(String line) {
            String[] split = line.split(",");
            this.name = split[0];
            this.time = Integer.parseInt(split[1]);
            this.amount = Integer.parseInt(split[2]);
            this.city = split[3];
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        List<String> invalid = new ArrayList<>();
        Map<String, List<Transaction>> map = new HashMap<>();
        for(String line: transactions) {
            Transaction t = new Transaction(line);
            map.putIfAbsent(t.name, new ArrayList<>());
            map.get(t.name).add(t);
        }

        for(String line: transactions) {
            Transaction t = new Transaction(line);
            if(!isValid(t, map.getOrDefault(t.name, new ArrayList<>()))) {
                invalid.add(line);
            }
        }

        return invalid;
    }

    private static boolean isValid(Transaction t, List<Transaction> list) {
        if(t.amount > 1000) return false;

        for(Transaction ta: list) {
            if(Math.abs(ta.time - t.time) <= 60 && !ta.city.equals(t.city)) {
                return false;
            }
        }

        return true;
    }
}
