package com.css.spring.rest.util;

/**
 * @author Kishore Routhu on 22/7/17 8:57 PM.
 */
public final class StringWrapper {

    public static final StringWrapper SUCCESS_RESPONSE = new StringWrapper("succes");

    private final String result;

    public StringWrapper(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
