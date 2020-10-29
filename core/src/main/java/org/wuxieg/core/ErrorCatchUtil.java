package org.wuxieg.core;

import org.slf4j.Logger;

public class ErrorCatchUtil {
    public static void  printErrorMessage(Throwable throwable, Logger logger){
        logger.error("catch exception message: {}",throwable.getMessage());
    }
}
