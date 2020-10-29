package org.wuxieg.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientHandler {
    private static final Logger logger = LoggerFactory.getLogger(ClientHandler.class);

    private static final int MAX_DATA_LEN = 100;
    private final Socket client;

    public ClientHandler(Socket socket){
        this.client = socket;
    }

    public void start(){
        logger.info("client accept ");
        new Thread(this::doStart).start();
    }

    private void doStart(){
        try {
            InputStream inputStream = this.client.getInputStream();
            while (true){
                byte[] data = new byte[MAX_DATA_LEN];
                int len;
                while ((len = inputStream.read(data)) != -1){
                    String message = new String(data,0,len);
                    logger.info("client send message: {}",message);
                    this.client.getOutputStream().write(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
