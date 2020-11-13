package com.rmaj91.udp;

import java.io.IOException;
import java.net.*;

public class UdpSocketClient {

    public static final int SEVER_PORT = 9999;

    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        String message = "message";
        DatagramPacket datagramPacket = new DatagramPacket(message.getBytes(), 0, message.length(),
                InetAddress.getLocalHost(), SEVER_PORT);
        datagramSocket.send(datagramPacket);
    }
}
