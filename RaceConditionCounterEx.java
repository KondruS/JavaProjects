package org.example.threadingandexecutor;

public class RaceConditionCounterEx {
    protected long count = 0;
    public Integer sum1;
    public Integer sum2;
    public Integer val1;
    public Integer val2;

    public void add(long value){
        // Imagine if two threads, A and B, are executing the add method on the same instance of the RaceConditionCounterEx class.
        //To prevent race condition we need to use synchronized block and also only synchronize
        // the part of code, not the entire method
        synchronized(this){
            this.sum1 += val1;
            this.sum2 += val2;
        }
        this.count = this.count + value;
    }
}
