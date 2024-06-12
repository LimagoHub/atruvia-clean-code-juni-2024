package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

       new Main().run();
    }

    private void run() {
        try {
            ExecutorService service = Executors.newFixedThreadPool(4);

            service.execute(new SinnDesLebens());
            service.execute(new SinnDesLebens());
            service.execute(new Runnable() {
                @Override
                public void run() {

                }
            });
            service.execute(this::foo);

            service.shutdown();
            System.out.println("Hello world!");
            service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

            System.out.println("Hello world!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void foo() {
        //
    }

    class SinnDesLebens implements Runnable {
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}