package com.rmaj91.udp.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import static com.rmaj91.Constants.*;

public class UdpMultiCastClient {

    public static void main(String[] args) throws IOException {
        MulticastSocket multicastSocket = new MulticastSocket(MULTICAST_PORT);
        multicastSocket.joinGroup(InetAddress.getByName(MULTICAST_GROUP));
        byte[] buffer = new byte[256];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);

        multicastSocket.receive(datagramPacket);

        System.out.println("Receive data from: " + datagramPacket.getAddress());
        System.out.println("Receive data from: " + datagramPacket.getPort());
        System.out.println("Receive data from: " + new String(datagramPacket.getData(), 0 , datagramPacket.getLength()));

        multicastSocket.leaveGroup(InetAddress.getByName(MULTICAST_GROUP));
        multicastSocket.close();
    }
}
