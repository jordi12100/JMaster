package com.jordi.gaming.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer implements Runnable {
    protected static Logger logger = LoggerFactory.getLogger(UdpServer.class);

    protected DatagramSocket udpSocket;

    protected byte[] receiveData = new byte[1024];

    /**
     * @param port Port
     */
    public UdpServer(Integer port) throws SocketException {
        udpSocket = new DatagramSocket(port);
    }

    public void run()
    {
        while(true) {
            DatagramPacket packet = new DatagramPacket(receiveData, receiveData.length);
            try {
                udpSocket.receive(packet);
                new Thread(new UdpRequest(udpSocket, packet)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

