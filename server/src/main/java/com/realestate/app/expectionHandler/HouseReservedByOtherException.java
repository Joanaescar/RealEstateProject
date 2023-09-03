package com.realestate.app.expectionHandler;

public class HouseReservedByOtherException extends RuntimeException {

    public HouseReservedByOtherException() {
    }

    public HouseReservedByOtherException(String message) {
        super(message);
    }

    public HouseReservedByOtherException(String message, Throwable cause) {
        super(message, cause);
    }

    public HouseReservedByOtherException(Throwable cause) {
        super(cause);
    }

    public HouseReservedByOtherException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
