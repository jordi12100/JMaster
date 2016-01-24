package com.jordi.gaming.Socket.Handler;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class PingHandler implements RequestHandlerInterface {
    /**
     * @param udpSocket DatagramSocket
     * @param request String
     * @param packet DatagramPacket
     */
    public Boolean canHandle(DatagramSocket udpSocket, String request, DatagramPacket packet)
    {
        System.out.println(request);

        return request.equals("ping");
    }

    /**
     * @param udpSocket DatagramSocket
     * @param request String
     * @param packet DatagramPacket
     */
    public void handle(DatagramSocket udpSocket, String request, DatagramPacket packet)
    {

    }
}
