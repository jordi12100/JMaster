package com.jordi.gaming.Socket.Handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

public class UptimeHandler implements RequestHandlerInterface
{
    protected static Logger logger = LoggerFactory.getLogger(UptimeHandler.class);

    /**
     * @param udpSocket DatagramSocket
     * @param request String
     * @param packet DatagramPacket
     */
    public Boolean canHandle(DatagramSocket udpSocket, String request, DatagramPacket packet)
    {
        return request.equals("uptime");
    }

    /**
     * @param udpSocket DatagramSocket
     * @param request String
     * @param packet DatagramPacket
     */
    public void handle(DatagramSocket udpSocket, String request, DatagramPacket packet)
    {
        logger.info("Uptime request from " + packet.getAddress().getHostAddress() + ":" + packet.getPort());

        try {
            this.sendUptimeToSocket(udpSocket, packet.getAddress(), packet.getPort());
            logger.debug("Replied with " + new String(this.getUptimeInBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return byte[]
     */
    protected byte[] getUptimeInBytes()
    {
        RuntimeMXBean rb = ManagementFactory.getRuntimeMXBean();
        long uptime = rb.getUptime();

        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(uptime);
        return buffer.array();
    }

    /**
     * @param address InetAddress
     * @param port Integer
     */
    protected void sendUptimeToSocket(DatagramSocket udpSocket, InetAddress address, Integer port) throws IOException
    {
        byte[] data = this.getUptimeInBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);

        udpSocket.send(packet);
    }
}
