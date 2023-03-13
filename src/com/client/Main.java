package com.client;

/**
 * @author Mikhail Iumanov
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.start();
        client.listen();
    }
}
