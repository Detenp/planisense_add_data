package com.lbounouar.app.utils.exceptions;

/**
 * Class for exceptions that should not instantly make the app stop
 */
public class DataException extends Exception {
    public DataException(String msg, Exception e) {
        super(msg, e);
    }
}
