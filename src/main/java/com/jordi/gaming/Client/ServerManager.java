package com.jordi.gaming.Client;

import java.util.ArrayList;
import java.util.List;

public class ServerManager
{
    protected List<Server> servers;

    /**
     * @param servers List<Server>
     */
    public ServerManager(List<Server> servers) {
        this.servers = new ArrayList<Server>();
    }

    /**
     * @param server Server
     */
    public void register(Server server)
    {
        servers.add(server);
    }

    /**
     * @param server Server
     */
    public void unRegister(Server server)
    {
        servers.remove(server);
    }

    /**
     * @return servers List<Server>
     */
    public List<Server> listServers()
    {
        return servers;
    }
}
