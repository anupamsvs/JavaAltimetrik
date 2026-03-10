package Multithreading;

public class Printer {
    boolean isOdd = false; // false means odd should print first

    synchronized void printEven(int number) {
        while (isOdd == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Even thread interrupted!");
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Printing even number = " + number);
        isOdd = false;
        notifyAll();
    }

    synchronized void printOdd(int number) {
        while (isOdd == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Odd thread interrupted!");
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Printing odd number = " + number);
        isOdd = true;
        notifyAll();
    }
}
