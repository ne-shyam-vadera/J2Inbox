package com.springpoc.J2Inbox;

import com.springpoc.J2Inbox.controller.TempUsageController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@ComponentScan("com.springpoc.J2Inbox")
@ComponentScan(basePackageClasses = TempUsageController.class)
@SpringBootApplication
public class J2InboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(J2InboxApplication.class, args);
	}

}
