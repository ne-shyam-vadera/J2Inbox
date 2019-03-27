package com.springpoc.J2Inbox.exception;

import com.springpoc.J2Inbox.util.J2InboxUtils;
import javassist.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.TimeoutException;

@ControllerAdvice
public class J2InboxException  extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleExceptions(
            Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                new J2InboxUtils().getErrorMessage("Something went wrong."), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ NotFoundException.class })
    public ResponseEntity<Object> msgIdNotAvailableExceptions(
            Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                new J2InboxUtils().getErrorMessage("Message Id is not available."), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ TimeoutException.class })
    public ResponseEntity<Object> timeOutExceptions(
            Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                new J2InboxUtils().getErrorMessage("Request time out."), new HttpHeaders(), HttpStatus.REQUEST_TIMEOUT);
    }


}
