package Multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EvenOddWithLock {

    ReentrantLock lock = new ReentrantLock();
    Condition oddCondition = lock.newCondition();
    Condition evenCondition = lock.newCondition();

    int number = 1;
    int max;

    public EvenOddWithLock(int max) {
        this.max = max;
    }

    static void main() {
        EvenOddWithLock evenOddWithLock = new EvenOddWithLock(10);
        Thread t1 = new Thread(() -> evenOddWithLock.printOdd(evenOddWithLock));
        Thread t2 = new Thread(() -> evenOddWithLock.printEven(evenOddWithLock));
        t1.start();
        t2.start();
    }

    private void printEven(EvenOddWithLock evenOddWithLock) {
        lock.lock();
        try {
            while (number < evenOddWithLock.max) {
                while (number % 2 != 0) {
                    evenCondition.await();
                }
                System.out.println("Printing Even :" + number);
                number++;
                oddCondition.signal();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    private void printOdd(EvenOddWithLock evenOddWithLock) {
        lock.lock();
        try {
            while (number < evenOddWithLock.max) {
                while (number % 2 == 0) {
                    oddCondition.await();
                }
                System.out.println("Printing Odd : " + number);
                number++;
                evenCondition.signal();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}
