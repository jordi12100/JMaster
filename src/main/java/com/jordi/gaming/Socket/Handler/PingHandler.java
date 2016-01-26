package com.jordi.gaming.Socket.Handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class PingHandler implements RequestHandlerInterface
{
    protected static Logger logger = LoggerFactory.getLogger(PingHandler.class);

    /**
     * @param udpSocket DatagramSocket
     * @param request String
     * @param packet DatagramPacket
     */
    public Boolean canHandle(DatagramSocket udpSocket, String request, DatagramPacket packet)
    {
        return request.equals("ping");
    }

    /**
     * @param udpSocket DatagramSocket
     * @param request String
     * @param packet DatagramPacket
     */
    public void handle(DatagramSocket udpSocket, String request, DatagramPacket packet)
    {
        logger.info("Request received: " + request + " from " + packet.getAddress().getHostAddress() + ":" + packet.getPort());
    }
}
