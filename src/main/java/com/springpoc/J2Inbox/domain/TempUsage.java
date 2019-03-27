package com.springpoc.J2Inbox.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "j2es_template_usage")
public class TempUsage {

    @Id
    @Column(name = "message_id")
    @JsonProperty(value="msg_id")
    private String messageId;

    @Column(name = "j2es_version")
    @JsonProperty(value="j2es_version")
    private Double j2esVersion;

    @JsonProperty(value="site")
    private String site;

    @JsonProperty(value="brand")
    private String brand;

    @Column(name = "email_package")
    @JsonProperty(value="email_package")
    private String emailPackage;

    @JsonProperty(value="language")
    private String language;

    @JsonProperty(value="encoding")
    private String encoding;

    @Column(name = "email_name")
    @JsonProperty(value="email_name")
    private String emailName;

    @Column(name = "dequeue_time")
    @JsonProperty(value="dequeue_time")
    @JsonFormat(pattern = "dd-MMM-yy hh.mm.ss.SSS aa")
    private Date dequeueTime;

    @Column(name = "sent_time")
    @JsonProperty(value="sent_time")
    @JsonFormat(pattern = "dd-MMM-yy hh.mm.ss.SSS aa")
    private Date sentTime;

}
