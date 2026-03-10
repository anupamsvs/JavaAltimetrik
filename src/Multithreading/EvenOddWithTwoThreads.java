package Multithreading;

public class EvenOddWithTwoThreads implements Runnable {

    private boolean isEven;
    private Printer printer;

    public EvenOddWithTwoThreads(boolean isEven, Printer printer) {
        this.isEven = isEven;
        this.printer = printer;
    }

    @Override
    public void run() {
        int max = 10;
        int number = isEven ? 2 : 1;
        while (number <= max) {
            if (isEven) {
                printer.printEven(number);
            } else {
                printer.printOdd(number);
            }
            number += 2;
        }
    }
}

