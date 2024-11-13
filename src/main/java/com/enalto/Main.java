package com.enalto;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {
        System.out.println("Start main");

        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < 1000; i++) {
            //new Thread(this::handleUserRequests).start();
            Thread.startVirtualThread(()->handleUserRequests());
        }
        System.out.println("End main");
    }

    private void handleUserRequests() {
        System.out.println("Start thread "+Thread.currentThread());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End thread "+Thread.currentThread());
    }

}