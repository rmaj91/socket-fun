package com.rmaj91.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import static com.rmaj91.Constants.SERVER_PORT;

public class TcpSocketClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), SERVER_PORT);
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter socketOut = new PrintWriter(outputStream, true);
        BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String message = console.readLine();
        while (!message.equals("exit")) {
            socketOut.println(message);
            System.out.println(socketIn.readLine());
            message = console.readLine();
        }
        socketOut.println(message);

        socketOut.close();
        socketIn.close();
        console.close();
    }
}
