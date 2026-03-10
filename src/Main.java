import Concepts.Animal;
import Multithreading.EvenOddWithTwoThreads;
import Multithreading.Printer;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();

        EvenOddWithTwoThreads runnableEven = new EvenOddWithTwoThreads(true, printer);
        EvenOddWithTwoThreads runnableOdd = new EvenOddWithTwoThreads(false, printer);

        Thread tEven = new Thread(runnableEven);
        Thread tOdd = new Thread(runnableOdd);

        tEven.start();
        tOdd.start();

        Animal animal = new Animal("Elephant", "Herbivore", 4);
        System.out.printf("Animal is name %s, type is %s and has %s legs", animal.name(), animal.type(), animal.legs());
    }
}