package com.jordi.gaming.Socket.Handler;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public interface RequestHandlerInterface {
    /**
     * @param udpSocket DatagramSocket
     * @param request String
     * @param packet DatagramPacket
     */
    public Boolean canHandle(DatagramSocket udpSocket, String request, DatagramPacket packet);
    /**
     * @param udpSocket DatagramSocket
     * @param request String
     * @param packet DatagramPacket
     */
    public void handle(DatagramSocket udpSocket, String request, DatagramPacket packet);
}
