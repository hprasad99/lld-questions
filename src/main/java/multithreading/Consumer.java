package multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable{
    private final BlockingQueue<Integer> queue;
    private final Integer consumerId;
    private volatile boolean running = true;

    public Consumer(BlockingQueue<Integer> queue, Integer consumerId) {
        this.queue = queue;
        this.consumerId = consumerId;
    }

    @Override
    public void run() {
        try {
            while(running) {
                int item = queue.take();
                System.out.println("Consumer " + consumerId + " consumed " + item);
                Thread.sleep(ThreadLocalRandom.current().nextInt(500));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Consumer " + consumerId + " was interrupted");
        }
    }

    public void stop() {
        running = false;
    }
}
