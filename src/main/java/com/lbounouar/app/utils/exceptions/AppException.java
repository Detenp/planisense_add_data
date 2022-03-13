package com.lbounouar.app.utils.exceptions;

/**
 * Class for exceptions that should instantly make the app stop
 */
public class AppException extends Exception{
    public AppException(String msg, Exception e) {
        super(msg, e);
    }

    public AppException(String msg) {
        super(msg);
    }

    public AppException(Exception e) {
        super(e);
    }
}
