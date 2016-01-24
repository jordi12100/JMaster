package com.jordi.gaming.Socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer implements Runnable {
    protected DatagramSocket udpSocket;

    protected byte[] receiveData = new byte[1024];

    /**
     * @param port Port
     */
    public UdpServer(Integer port) {
        try {
            udpSocket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void run()
    {
        while(true) {
            DatagramPacket packet = new DatagramPacket(receiveData,
                    receiveData.length);
            try {
                udpSocket.receive(packet);
                new Thread(new UdpRequest(udpSocket, packet)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

