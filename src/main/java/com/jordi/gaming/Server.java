package com.jordi.gaming;

import com.jordi.gaming.Socket.UdpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.SocketException;

public class Server {
    protected static Logger logger = LoggerFactory.getLogger(Main.class);

    protected Integer port;

    /**
     * @param port Port
     */
    public Server(Integer port)
    {
        this.port = port;
    }

    public void start()
    {
        try {
            UdpServer udpServer = new UdpServer(this.port);
            new Thread(udpServer).start();

            logger.info("Server listening on port " + this.port);
        } catch (SocketException e) {
            logger.error("Could not start UDP Server");
            logger.debug(e.getStackTrace().toString());
        }
    }
}
