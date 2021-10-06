package org.iesfm.threadsSafe.synchronize;

public class Accumulator {

    private int times;

    public Accumulator() {
        this.times = 0;
    }

    public synchronized void inc() {
        times++;
    }

    public synchronized void dec() {
        times--;
    }

    public int getTimes() {
        return times;
    }
}
