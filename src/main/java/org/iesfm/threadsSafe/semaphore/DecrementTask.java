package org.iesfm.threadsSafe.semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Semaphore;

public class DecrementTask implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(DecrementTask.class);

    private Semaphore semaphore;
    private Accumulator acc;
    private int times;


    public DecrementTask(Semaphore semaphore, Accumulator acc, int times) {
        this.semaphore = semaphore;
        this.acc = acc;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            try {
                semaphore.acquire();
                acc.dec();
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
