package org.wuxieg.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Socket;

public class Client {
    private static Logger logger = LoggerFactory.getLogger(Client.class);
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8888;
    private static final int SLEEP_TIME = 5000;


    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(HOST,PORT);

        new Thread(() -> {
            while (true){
                String message = "Hello World";
                try {
                    socket.getOutputStream().write(message.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sleep();
            }
        }).start();
        logger.info("socket client start on {}:{}",HOST,PORT);
    }

    private static void sleep(){
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
