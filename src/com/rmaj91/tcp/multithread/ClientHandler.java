package com.rmaj91.tcp.multithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket client;

    public ClientHandler(Socket socket) {
        this.client = socket;
    }

    @Override
    public void run() {
        System.out.println("Connected client nr: " + Thread.currentThread().getName());
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
             PrintWriter printWriter = new PrintWriter(client.getOutputStream(), true)) {
            String line = bufferedReader.readLine();
            while (!line.equals("exit")) {
                printWriter.println(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Client nr: " + Thread.currentThread().getName() + " disconnected:");
        }
    }
}
