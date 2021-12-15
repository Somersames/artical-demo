package xyz.cyclicBarrier_use;

import java.util.concurrent.*;

public class CyclicBarrierTest1 {

    Executor executor = new ThreadPoolExecutor(1,2,10, TimeUnit.SECONDS,new LinkedBlockingDeque<>(10));

    private void test1() throws BrokenBarrierException, InterruptedException, TimeoutException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        Thread t1 = new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                cyclicBarrier.await(500,TimeUnit.SECONDS);
                System.out.println("t2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException, TimeoutException {
        new CyclicBarrierTest1().test1();
    }
}
