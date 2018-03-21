package com.pixelfederation.qa.automation.core.utils;

public final class StackTrace {
    public static String getLastClassMethodCall(Class classToCheck) {
        String lastCalledMethod = "";
        String className = classToCheck.getName();

        StackTraceElement[] stackTraceAll = (new Throwable()).getStackTrace();
        for (StackTraceElement stackTrace : stackTraceAll) {
            if (!stackTrace.getClassName().equals(className)) {
                break;
            }

            lastCalledMethod = stackTrace.getMethodName();
        }

        return lastCalledMethod;
    }
}