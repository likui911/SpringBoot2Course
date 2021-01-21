package com.spring.services;

public class ClientService {
    private static ClientService clientService = new ClientService();
    private ClientService() {}

    public static ClientService createInstance() {
        return clientService;
    }
    public void doSomething(){
        System.out.println(this);
        System.out.println("doing....");
    }
}
