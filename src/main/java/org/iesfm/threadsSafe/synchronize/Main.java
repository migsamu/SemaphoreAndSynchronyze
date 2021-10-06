package org.iesfm.threadsSafe.synchronize;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Accumulator acc = new Accumulator();
        IncrementTask incrementTask = new IncrementTask(acc, 5000);
        DecrementTask decrementTask = new DecrementTask(acc, 100);

        Thread incThread = new Thread(incrementTask);
        Thread decThread = new Thread(decrementTask);

        incThread.start();
        decThread.start();

        try {
            incThread.join();
            decThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("Se incrementa " + acc.getTimes() + " veces");
    }
}
