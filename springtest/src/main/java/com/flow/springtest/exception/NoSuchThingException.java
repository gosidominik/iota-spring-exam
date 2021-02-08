package com.flow.springtest.exception;

import javax.xml.bind.ValidationException;

public class NoSuchThingException extends ValidationException {
    public NoSuchThingException(String message) {
        super(message);
    }
}
