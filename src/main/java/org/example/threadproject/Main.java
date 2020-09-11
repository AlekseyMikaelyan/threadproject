package org.example.threadproject;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);

        thread1.setName("Producer");
        thread2.setName("Consumer");

        thread1.start();
        thread2.start();
    }
}
