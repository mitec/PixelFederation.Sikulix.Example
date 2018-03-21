package com.pixelfederation.qa.automation.core.driver;

public final class DriverException extends Exception {
    public DriverException(String message) {
        super(message);
    }

    public DriverException(Throwable cause) {
        super(cause);
    }

    public DriverException(String message, Throwable cause) {
        super(message, cause);
    }
}