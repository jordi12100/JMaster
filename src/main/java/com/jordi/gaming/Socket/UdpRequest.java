package com.jordi.gaming.Socket;

import com.jordi.gaming.Socket.Handler.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;

public class UdpRequest implements Runnable {
    protected DatagramSocket socket;

    protected DatagramPacket packet;

    protected List<RequestHandlerInterface> requestHandlers;

    protected static Logger logger = LoggerFactory.getLogger(UdpRequest.class);

    /**
     * @param socket DatagramSocket
     * @param packet DatagramPacket
     */
    public UdpRequest(DatagramSocket socket, DatagramPacket packet) {
        this.socket = socket;
        this.packet = packet;

        this.requestHandlers = this.getDefaultRequestHandlers();
    }

    public void run() {
        byte[] receivedBytes = packet.getData();
        if (receivedBytes == null || packet.getLength() == 0) {
            return;
        }

        String request = new String(packet.getData(), 0, packet.getLength());

        for (RequestHandlerInterface handler : requestHandlers) {
            if (!handler.canHandle(this.socket, request, packet)) {
                continue;
            }

            logger.debug("Calling requestHandler for class '" + handler.getClass().getName() + "'");

            handler.handle(this.socket, request, packet);
        }
    }

    /**
     * @return List<RequestHandlerInterface>
     */
    protected List<RequestHandlerInterface> getDefaultRequestHandlers()
    {
        List<RequestHandlerInterface> handlers = new ArrayList<RequestHandlerInterface>();

        handlers.add(new PingHandler());
        handlers.add(new UptimeHandler());

        return handlers;
    }
}

