package com.realestate.app.expectionHandler;

public class HouseAlreadyAvailableException extends RuntimeException {

    public HouseAlreadyAvailableException() {
    }

    public HouseAlreadyAvailableException(String message) {
        super(message);
    }

    public HouseAlreadyAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public HouseAlreadyAvailableException(Throwable cause) {
        super(cause);
    }

    public HouseAlreadyAvailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
