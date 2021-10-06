package org.iesfm.threadsSafe.synchronize;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class IncrementTask implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(IncrementTask.class);

    private Accumulator acc;
    private int times;

    public IncrementTask(Accumulator acc, int times) {
        this.acc = acc;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            acc.inc();
        }
    }
}
