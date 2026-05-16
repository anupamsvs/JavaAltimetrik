package Multithreading;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer extends Thread {
    private static final int MAX_SIZE = 10;
    private int value;
    private static List<Integer> list = new ArrayList<>();

    synchronized void produce(List<Integer> list) {
        while(true) {
            while(list.size() >= MAX_SIZE) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            while(list.size() < MAX_SIZE) {
                list.add(value);
                System.out.println("Value produced in queue = " + value);
                value++;
            }
            notifyAll();
        }
    }
    synchronized void consume(List<Integer> list) {
        while(true) {
            while(list.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            while(!list.isEmpty()) {
                int firstElement = list.removeFirst();
                System.out.println("Value consumed from queue = " + firstElement);
            }
            notifyAll();
        }
    }

    static void main() {
        ProducerConsumer producer = new ProducerConsumer();
        ProducerConsumer consumer = new ProducerConsumer();

        producer.produce(list);
        consumer.consume(list);

        producer.start();
        consumer.start();
    }
}
