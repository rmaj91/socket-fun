package com.rmaj91.udp.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import static com.rmaj91.Constants.MULTICAST_GROUP;
import static com.rmaj91.Constants.MULTICAST_PORT;

public class UdpMulticastServer {

    public static void main(String[] args) throws IOException {
        MulticastSocket multicastSocket = new MulticastSocket();
        String message = "multicast mesage";
        DatagramPacket datagramPacket = new DatagramPacket(message.getBytes(), message.length(),
                InetAddress.getByName(MULTICAST_GROUP), MULTICAST_PORT);
        multicastSocket.send(datagramPacket);
        multicastSocket.close();
    }
}
