package org.iesfm.threadsSafe.semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Semaphore;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final Semaphore semaphore = new Semaphore(1);

    private static final Accumulator acc = new Accumulator();

    public static void main(String[] args) {

        IncrementTask incrementTask = new IncrementTask(semaphore, acc, 100);
        DecrementTask decrementTask = new DecrementTask(semaphore, acc, 100);

        Thread t = new Thread(incrementTask);
        Thread t2 = new Thread(decrementTask);

        t.start();
        t2.start();

        try {
            t.join();
            t2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        log.info("Incrementa un total de " + acc.getTimes() + " veces");
    }
}
