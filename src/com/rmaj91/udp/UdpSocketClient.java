package com.rmaj91.udp;

import java.io.IOException;
import java.net.*;

import static com.rmaj91.Constants.SERVER_PORT;

public class UdpSocketClient {


    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        String message = "message";
        DatagramPacket datagramPacket = new DatagramPacket(message.getBytes(), 0, message.length(),
                InetAddress.getLocalHost(), SERVER_PORT);
        datagramSocket.send(datagramPacket);
    }
}
