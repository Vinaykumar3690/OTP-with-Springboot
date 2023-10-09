package com.vinaykumar;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.twilio.Twilio;
import com.vinaykumar.config.TwilioConfig;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EnableConfigurationProperties
public class OtpApplication {
	
    private static final Logger logger = LogManager.getLogger(OtpApplication.class);


	@Autowired
	private TwilioConfig twilioConfig;

	@PostConstruct
	public void setup() {
		Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
	}

	public static void main(String[] args) {
		
        logger.info("This is an INFO log message.");

		SpringApplication.run(OtpApplication.class, args);
		
        logger.error("This is an ERROR log message2");

	}

}
