package org.iesfm.threadsSafe.semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Semaphore;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {


        Semaphore semaphore = new Semaphore(1);
        Accumulator acc = new Accumulator();

        IncrementTask incrementTask = new IncrementTask(semaphore, acc, 100);
        DecrementTask decrementTask = new DecrementTask(semaphore, acc, 100);
        Thread t = new Thread(incrementTask);

        Thread t2 = new Thread(decrementTask);
        t.start();
        t2.start();

        log.info("Incrementa un total de " + acc.getTimes() + " veces");
    }
}
