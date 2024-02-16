package org.example.threadingandexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPoolEx {
    // If we want tasks to be run in sequence then we use SingleThreadPool
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i=0;i<3;i++){
            executorService.execute(new RunnableEx());
        }
        executorService.shutdown();
    }
}
