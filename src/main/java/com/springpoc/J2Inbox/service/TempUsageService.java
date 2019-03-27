package com.springpoc.J2Inbox.service;

import com.springpoc.J2Inbox.domain.TempUsage;
import com.springpoc.J2Inbox.repository.TempUsageRepository;
import com.springpoc.J2Inbox.util.J2InboxUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TempUsageService {

    @Autowired
    TempUsageRepository tempUsageRepository;

    public ResponseEntity<Object>tempUsageList(){
        return ResponseEntity.ok().body(tempUsageRepository.findAll());
    }

    public ResponseEntity<Object> insertTempUsage(TempUsage tempUsage){
        List<TempUsage> tempUsageList=tempUsageRepository.getTempUsagebyMessageId(tempUsage.getMessageId());
        if(tempUsageList.size()==0){
            tempUsageRepository.save(tempUsage);
            return ResponseEntity.ok().body("Record Insert Successfully");
        }else{
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new J2InboxUtils().getErrorMessage("Message ID already exist,Please change it."));
        }

    }

    public ResponseEntity<Object>tempUsagebyMessageId(String messageId){
        if(messageId.isEmpty() || messageId==null){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new J2InboxUtils().getErrorMessage("Please enter message id."));
        }else{
            List<TempUsage> tempUsage=tempUsageRepository.getTempUsagebyMessageId(messageId);
            if(tempUsage.size()==1){
                return ResponseEntity.ok().body(tempUsage.get(0));
            }else{
                return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new J2InboxUtils().getErrorMessage("Message ID :"+ messageId+ " does not exist."));
            }
        }

    }

    public ResponseEntity<Object> deleteTempUsageDetails(String messageId){
        List<TempUsage> tempUsageList=tempUsageRepository.getTempUsagebyMessageId(messageId);
        if(tempUsageList.get(0)!=null){
            this.tempUsageRepository.delete(tempUsageList.get(0));
            return  ResponseEntity.ok().body("Record deleted successfully.");
        }else{
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new J2InboxUtils().getErrorMessage("Message ID :"+ messageId+ " does not exist."));
        }

    }

    public ResponseEntity<Object> updateTempUsageDetails(TempUsage tempUsage){
        List<TempUsage> tempUsageList=tempUsageRepository.getTempUsagebyMessageId(tempUsage.getMessageId());
        if(tempUsageList.get(0)!=null){
            tempUsageRepository.save(tempUsage);
            return  ResponseEntity.ok().body("Record update successfully.");
        }else{
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new J2InboxUtils().getErrorMessage("Message ID :"+ tempUsage.getMessageId()+ " does not exist."));
        }
    }


}
