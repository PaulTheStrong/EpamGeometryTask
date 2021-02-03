package com.epam.training.geomety.data;

public class DataException extends Exception {
    public DataException(String s) {
        super(s);
    }

    public DataException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
