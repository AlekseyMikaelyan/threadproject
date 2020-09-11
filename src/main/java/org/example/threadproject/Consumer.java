package org.example.threadproject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {

    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String temp = null;

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            while(true) {
                String input = queue.poll(1, TimeUnit.SECONDS);
                if (input != null) {
                    if (!input.equalsIgnoreCase("quit")) {
                        if (!input.equals(temp)) {
                            temp = input;
                            System.out.println(input);
                            writer.write(input);
                        }
                    } else {
                        break;
                    }
                }
            }
        } catch (IOException | InterruptedException ioException) {
            ioException.printStackTrace();
        }
    }

}
