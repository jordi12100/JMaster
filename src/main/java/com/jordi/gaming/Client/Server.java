package com.jordi.gaming.Client;

import java.util.ArrayList;
import java.util.List;

public class Server implements ClientInterface {

    protected String ip;

    protected Integer port;

    protected String name = "My awesome server";

    protected String description;

    protected Integer maxClients = 0;

    protected List<Client> clients;

    /**
     *
     * @param ip String
     * @param port Integer
     */
    public Server(String ip, Integer port) {
        this.ip = ip;
        this.port = port;

        this.clients = new ArrayList<Client>();
    }

    public String getIp() {
        return ip;
    }

    public Integer getPort() {
        return port;
    }

    public String toString() {
        return this.ip + ":" + this.port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaxClients() {
        return maxClients;
    }

    public void setMaxClients(Integer maxClients) {
        this.maxClients = maxClients;
    }

    public List<Client> getClients() {
        return clients;
    }
}
