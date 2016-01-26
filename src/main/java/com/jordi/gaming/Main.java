package com.jordi.gaming;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main
{
    protected static Logger logger = LoggerFactory.getLogger(Main.class);

    @Parameter(names={"--port", "-p"}, description="Set port this server should listen on")
    protected Integer port = 30006;

    @Parameter(names={"--help", "-h"}, description="Display help information")
    protected Boolean help;

    /**
     * @param args String[]
     */
    public static void main(String[] args)
    {
        Main main = new Main();
        JCommander jCommander = new JCommander(main, args);
        jCommander.setProgramName("JMaster Server");
        if (main.help != null) {
            jCommander.usage();
            return;
        }

        main.run();
    }

    public void run() {
        logger.info("Starting Master Server");

        Server server = new Server(this.port);
        server.start();
    }
}
