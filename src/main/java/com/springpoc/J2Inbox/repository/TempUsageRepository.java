package com.springpoc.J2Inbox.repository;

import com.springpoc.J2Inbox.domain.TempUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TempUsageRepository extends JpaRepository<TempUsage,Integer> {

    @Query(value = "select * from j2es_template_usage jtu where jtu.message_id=?1",nativeQuery=true)
    List<TempUsage> getTempUsagebyMessageId(String messageId);


}
