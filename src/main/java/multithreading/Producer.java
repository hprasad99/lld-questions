package multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable{
    private final BlockingQueue<Integer> queue;
    private final Integer producerId;
    private volatile boolean running = true;

    public Producer(BlockingQueue<Integer> queue, Integer producerId) {
        this.queue = queue;
        this.producerId = producerId;
    }

    @Override
    public void run() {
        try {
            while(running) {
                Integer item = ThreadLocalRandom.current().nextInt(100);
                queue.put(item);
                System.out.println("Producer " + producerId + " produced " + item);
                Thread.sleep(ThreadLocalRandom.current().nextInt(500));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Producer " + producerId + " was interrupted");
        }
    }

    public void stop() {
        running = false;
    }
}
