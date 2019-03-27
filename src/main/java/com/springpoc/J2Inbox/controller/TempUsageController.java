package com.springpoc.J2Inbox.controller;

import com.springpoc.J2Inbox.domain.TempUsage;
import com.springpoc.J2Inbox.exception.J2InboxException;
import com.springpoc.J2Inbox.service.TempUsageService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.concurrent.TimeoutException;

@RestController
public class TempUsageController {

    @Autowired
    TempUsageService tempUsageService;


    @GetMapping("/temp_usages")
    public ResponseEntity<Object>getTempUsageList(WebRequest webRequest){
        try {
            return tempUsageService.tempUsageList();
        }catch (Exception ex){
            if(ex instanceof NotFoundException){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new J2InboxException().msgIdNotAvailableExceptions(ex,webRequest));
            }else if(ex instanceof TimeoutException){
                return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body(new J2InboxException().timeOutExceptions(ex,webRequest));
            }else{
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new J2InboxException().handleExceptions(ex,webRequest));
            }
        }
    }


    @GetMapping("/temp_usage/{message_id}")
    public ResponseEntity<Object>getTempUsageByMessageId(WebRequest webRequest,@PathVariable String message_id){
        try {
            return tempUsageService.tempUsagebyMessageId(message_id);
        }catch (Exception ex){
            if(ex instanceof NotFoundException){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new J2InboxException().msgIdNotAvailableExceptions(ex,webRequest));
            }else if(ex instanceof TimeoutException){
                return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body(new J2InboxException().timeOutExceptions(ex,webRequest));
            }else{
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new J2InboxException().handleExceptions(ex,webRequest));
            }
        }
    }

    @PostMapping("/temp_usage")
    public ResponseEntity<Object> createTempUsage(@RequestBody TempUsage tempUsage,WebRequest webRequest) {
        try {
            return tempUsageService.insertTempUsage(tempUsage);
        }catch (Exception ex){
            if(ex instanceof NotFoundException){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new J2InboxException().msgIdNotAvailableExceptions(ex,webRequest));
            }else if(ex instanceof TimeoutException){
                return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body(new J2InboxException().timeOutExceptions(ex,webRequest));
            }else{
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new J2InboxException().handleExceptions(ex,webRequest));
            }
        }

    }

    @PutMapping("/temp_usage")
    public ResponseEntity<Object>updateTempUsage(@RequestBody TempUsage tempUsage,WebRequest webRequest) {
        try {
            return tempUsageService.updateTempUsageDetails(tempUsage);
        }catch (Exception ex){
            if(ex instanceof NotFoundException){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new J2InboxException().msgIdNotAvailableExceptions(ex,webRequest));
            }else if(ex instanceof TimeoutException){
                return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body(new J2InboxException().timeOutExceptions(ex,webRequest));
            }else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new J2InboxException().handleExceptions(ex,webRequest));
            }
        }
    }

    @DeleteMapping("/temp_usage/{message_id}")
    public ResponseEntity<Object>deleteTempUsage(@PathVariable String message_id,WebRequest webRequest){
        try {
            return tempUsageService.deleteTempUsageDetails(message_id);
        }catch (Exception ex){
            if(ex instanceof NotFoundException){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new J2InboxException().msgIdNotAvailableExceptions(ex,webRequest));
            }else if(ex instanceof TimeoutException){
                return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body(new J2InboxException().timeOutExceptions(ex,webRequest));
            }else{
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new J2InboxException().handleExceptions(ex,webRequest));
            }
        }

    }
}
