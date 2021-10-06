package org.iesfm.threadsSafe.synchronize;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DecrementTask implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(DecrementTask.class);

    private Accumulator acc;
    private int times;


    public DecrementTask(Accumulator acc, int times) {
        this.acc = acc;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            acc.dec();
        }
    }
}
