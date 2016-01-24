package com.jordi.gaming;

import com.jordi.gaming.Socket.UdpServer;

public class Server {
    private Integer port;

    /**
     * @param port Port
     */
    public Server(Integer port)
    {
        this.port = port;
    }

    public void start()
    {
        UdpServer udpServer = new UdpServer(this.port);
        System.out.println("Server listening on port " + this.port);

        new Thread(udpServer).start();
    }
}
