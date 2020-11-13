package com.rmaj91.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpSocketServer {

    public static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(PORT);
        byte[] buffer = new byte[256];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
        long start = System.nanoTime();
        while (System.nanoTime() - start < 2_000_000_000_0L) {
            datagramSocket.receive(datagramPacket);
            byte[] data = datagramPacket.getData();
            String message = new String(data);
            System.out.println(message + ": " + datagramPacket.getPort());
        }
    }
}
