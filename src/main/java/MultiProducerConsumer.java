import multithreading.Consumer;
import multithreading.Producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MultiProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        int numProducers = 3;
        int numConsumers = 3;

        Producer[] producers = new Producer[numProducers];
        Thread[] producerThreads = new Thread[numProducers];

        // Start producer thread
        for(int i=0; i<numProducers; i++) {
            producers[i] = new Producer(queue, i+1);
            producerThreads[i] = new Thread(producers[i]);
            producerThreads[i].start();
        }

        Consumer[] consumers = new Consumer[numConsumers];
        Thread[] consumerThreads = new Thread[numConsumers];
        // Start consumer thread
        for(int i=0; i<numConsumers; i++) {
           consumers[i] = new Consumer(queue, i+1);
           consumerThreads[i] = new Thread(consumers[i]);
           consumerThreads[i].start();
        }

        try {
            System.out.println("Thread Sleep: " + 5000);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(Producer producer: producers) {
            producer.stop();
        }

        for(Consumer consumer: consumers) {
            consumer.stop();
        }

        for(Thread producerThread : producerThreads) {
            producerThread.interrupt();
        }

        for(Thread consumerThread : consumerThreads) {
            consumerThread.interrupt();
        }
    }
}
