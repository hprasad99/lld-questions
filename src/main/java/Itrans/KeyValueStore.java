package Itrans;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class KeyValueStore {
    private final Map<String, String> store = new HashMap<>();
    private final Map<Long, Transaction> transactions = new HashMap<>();
    private final Lock lock = new ReentrantLock();
    private long transactionCounter = 0;

    public long beginTransaction() {
        lock.lock();
        try {
            long transactionId = ++transactionCounter;
            transactions.put(transactionId, new Transaction());
            return transactionId;
        } finally {
            lock.unlock();
        }
    }

    public void commitTransaction(long transactionId) throws Exception {
        lock.lock();
        try {
            Transaction transaction = transactions.get(transactionId);
            if(Objects.isNull(transaction)) {
                throw new Exception("Invalid transaction Id");
            }

            for(Map.Entry<String, String> entry: transaction.getOperations().entrySet()) {
                if(entry.getValue() == null) {
                    store.remove(entry.getKey());
                } else {
                    store.put(entry.getKey(), entry.getValue());
                }
            }
            transactions.remove(transactionId);
        } finally {
            lock.unlock();
        }
    }

    public void rollbackTransaction(long transactionId) {
        lock.lock();
        try {
            transactions.remove(transactionId);
        } finally {
            lock.unlock();
        }
    }

    public void put(long transactionId, String key, String value) throws Exception {
        lock.lock();
        try {
            Transaction transaction = transactions.get(transactionId);
            if(Objects.isNull(transaction)) {
                throw new Exception("Invalid transaction ID");
            }
            transaction.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    public String get(String key) {
        lock.lock();
        try {
            return store.get(key);
        } finally {
            lock.unlock();
        }
    }

    public void delete(long transactionId, String key) throws Exception {
        lock.lock();
        try {
            Transaction transaction = transactions.get(transactionId);
            if(Objects.isNull(transaction)) {
                throw new Exception("Invalid transaction ID");
            }
            transaction.put(key, null);
        } finally {
            lock.unlock();
        }
    }

    private static class Transaction {
        private final Map<String, String> operations = new HashMap<>();

        public void put(String key, String value) {
            operations.put(key, value);
        }

        public Map<String, String> getOperations() {
            return operations;
        }
    }

    public static void main(String[] args) {
        try {
            KeyValueStore store = new KeyValueStore();
            long txn1 = store.beginTransaction();
            store.put(txn1, "key1", "value1");
            store.commitTransaction(txn1);
            System.out.println(store.get("key1"));

            long txn2 = store.beginTransaction();
            store.put(txn2, "key2", "value2");
            store.commitTransaction(txn2);
            System.out.println(store.get("key2"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
