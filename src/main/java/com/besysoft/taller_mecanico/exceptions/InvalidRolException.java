package com.besysoft.taller_mecanico.exceptions;

public class InvalidRolException extends Exception{

    public InvalidRolException(String message) {
        super(message);
    }

    public InvalidRolException(String message, Throwable cause) {
        super(message, cause);
    }
}
