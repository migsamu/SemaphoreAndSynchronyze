package org.iesfm.threadsSafe.semaphore;

public class Accumulator {

    private int times;

    public Accumulator() {
        this.times = 0;
    }

    public void inc() {
        times++;
    }

    public void dec() {
        times--;
    }

    public int getTimes() {
        return times;
    }
}
