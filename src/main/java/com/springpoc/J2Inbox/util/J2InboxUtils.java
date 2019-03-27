package com.springpoc.J2Inbox.util;

import com.springpoc.J2Inbox.domain.Errors;

public class J2InboxUtils {

    public Errors getErrorMessage(String message) {
        Errors error=new Errors();
        error.setError_message(message);
        return error;
    }
}
