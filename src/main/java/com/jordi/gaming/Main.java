package com.jordi.gaming;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class Main {
    @Parameter(names={"--port", "-p"}, description="Set port this server should listen on")
    protected Integer port = 30001;

    @Parameter(names={"--help", "-h"}, description="Display help information")
    protected Boolean help;

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
        Server server = new Server(this.port);
        server.start();
    }
}
