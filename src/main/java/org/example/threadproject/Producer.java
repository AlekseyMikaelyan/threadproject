package org.example.threadproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String s;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                s = reader.readLine();
                queue.put(s);
                if (s.equalsIgnoreCase("quit")) break;
            }
        } catch (IOException | InterruptedException ioException) {
            ioException.printStackTrace();
        }
    }
}

