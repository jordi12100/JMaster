package com.jordi.gaming.Client;

public class Client implements ClientInterface {

    protected String ip;

    protected Integer port;

    protected String name;

    public Client(String ip, Integer port) {
        this.ip = ip;
        this.port = port;
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
}
