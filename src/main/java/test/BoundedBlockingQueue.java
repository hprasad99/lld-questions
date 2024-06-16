package test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue<T> {
    private final Lock lock = new ReentrantLock();
    private final T[] queue;
    private int head;
    private int tail;
    private int size;

    public BoundedBlockingQueue(int capacity) {
        queue = (T[]) new Object[capacity];
    }

    // put operation
    public void put(T item) throws InterruptedException {
        synchronized (lock) {
            while(size == queue.length) {
                lock.wait();
            }
            queue[tail] = item;
            tail = (tail + 1) % queue.length;
            size++;
            lock.notifyAll();
        }
    }

    // take operation
    public T take() throws InterruptedException {
        synchronized (lock) {
            while(size == 0) {
                lock.wait();
            }
            T item = queue[head];
            head = (head + 1) % queue.length;
            size--;
            lock.notifyAll();
            return item;
        }
    }
}
