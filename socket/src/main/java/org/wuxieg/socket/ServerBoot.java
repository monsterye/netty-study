package org.wuxieg.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerBoot {
    private static int port = 8888;
    private static final Logger logger = LoggerFactory.getLogger(ServerBoot.class);

    public static void main(String[] args) {
        new Server(8888).start();
        logger.info("socket server start on {}", port);

    }
}
