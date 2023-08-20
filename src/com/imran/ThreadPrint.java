package com.imran;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadPrinter implements Runnable
{
    private static int counter = 1;
    private static int limit = 100;
    private static Object lock = new Object();
    private int remainder,noOfThreads;

    public ThreadPrinter(int remainder,int noOfThreads)
    {
        this.remainder = remainder;
        this.noOfThreads = noOfThreads;
    }

    @Override
    public void run() {
        synchronized (lock)
        {
            while(counter <= limit) {
                if (counter % noOfThreads == remainder) {
                    System.out.println(counter++);
                    lock.notifyAll();
                }
                else{
                    try {
                        if (counter < limit)
                            lock.wait();
                        else
                            break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

public class ThreadPrint {
    private static int noOfThreads = 1;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(noOfThreads);
        for(int i=0;i<noOfThreads;i++)
        {
            executorService.execute(new ThreadPrinter(i,noOfThreads));
        }

        executorService.shutdown();
    }
}
