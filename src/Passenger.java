import java.util.concurrent.Semaphore;
import java.util.concurrent.CountDownLatch;

public class Passenger extends Thread {

    Semaphore sem;
    CountDownLatch latch;
    int passengerNumber;

    public Passenger(Semaphore sem, CountDownLatch latch, int passengerNumber) {
        this.sem = sem;
        this.latch = latch;
        this.passengerNumber = passengerNumber;
    }

    public void run() {
        try {
            sem.acquire();
            System.out.println("Пассажир " + passengerNumber + " купил билет до ИК");
            sleep(1000);
            sem.release();
            latch.countDown();
        } catch (InterruptedException e) {
        }
    }
}