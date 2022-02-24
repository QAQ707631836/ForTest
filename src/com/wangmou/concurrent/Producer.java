package com.wangmou.concurrent;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    protected BlockingQueue queue = null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            queue.put("p1");
            Thread.sleep(5000);
            queue.put("p2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}