package com.realestate.app.expectionHandler;

public class HouseReservedException extends RuntimeException {

    public HouseReservedException() {
    }

    public HouseReservedException(String message) {
        super(message);
    }

    public HouseReservedException(String message, Throwable cause) {
        super(message, cause);
    }

    public HouseReservedException(Throwable cause) {
        super(cause);
    }

    public HouseReservedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
