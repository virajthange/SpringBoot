package com.spider.CustomExceptions;

public class NoProductException extends RuntimeException{
    public NoProductException(String msg) {
        super(msg);
    }

}
