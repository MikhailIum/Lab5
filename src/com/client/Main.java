package com.client;

public class Main {
    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.start();
        client.listen();
        client.finish();
    }
}
