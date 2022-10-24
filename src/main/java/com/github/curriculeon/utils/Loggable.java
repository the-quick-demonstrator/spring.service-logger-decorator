package com.github.curriculeon.utils;

import java.util.logging.Logger;

public interface Loggable {
    default void info(String message, Object... args) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.info(String.format(message, args));
    }
}
