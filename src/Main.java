import java.util.concurrent.Semaphore;
import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {

        final int SEATS_COUNT = 18;
        try {
            Semaphore semaphore = new Semaphore(3);
            CountDownLatch latch = new CountDownLatch(SEATS_COUNT + 3);
            for (int i = 1; i <= SEATS_COUNT; i++) {
                new Passenger(semaphore, latch, i).start();
            }

            while (latch.getCount() > 3) {
                Thread.sleep(1000);
            }

            Thread.sleep(1000);
            System.out.println("Все билеты проданы.");
            Thread.sleep(1000);
            System.out.println("Проверка мастером двигателя.");
            latch.countDown();
            Thread.sleep(1000);
            System.out.println("Ремни пристегнуты.");
            latch.countDown();
            Thread.sleep(1000);
            System.out.println("Заправка топлива на АЗС.");
            latch.countDown();
            Thread.sleep(1000);
            System.out.println("Поехали!");
        } catch (InterruptedException ie) {
        }
    }
}
//создать проект в котором будет реализована отправка маршрутки с вокзала на ИК
//маршрутка отравляется только в том случае если количество пассажиров равно количеству мест в салоне
//так же маршрутка отравится только в том случае если бензина достаточно для путешествия и если двигатель исправен
