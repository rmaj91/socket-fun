package com.rmaj91.tcp.multithread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.rmaj91.Constants.SERVER_PORT;

public class TcpMultiThreadServer {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            int i = 0;
            while (true) {
                Socket accept = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(accept);
                Thread thread = new Thread(clientHandler, String.valueOf(i++));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
