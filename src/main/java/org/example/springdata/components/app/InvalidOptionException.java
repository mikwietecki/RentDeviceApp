package org.example.springdata.components.app;

public class InvalidOptionException extends RuntimeException {
    InvalidOptionException() {
        super("Opcja nie istnieje");
    }
}
