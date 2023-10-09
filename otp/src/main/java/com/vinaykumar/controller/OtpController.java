package com.vinaykumar.controller;
import org.slf4j.Logger;



import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.rest.serverless.v1.service.environment.Log;
import com.vinaykumar.dto.OtpRequest;
import com.vinaykumar.dto.OtpResponseDto;
import com.vinaykumar.dto.OtpValidationRequest;
import com.vinaykumar.service.SmsService;

import lombok.extern.log4j.Log4j;




@RestController
@RequestMapping("/otp")
@Log4j
public class OtpController {
	
	private static final Logger log = LoggerFactory.getLogger(OtpController.class);


	@Autowired
	private SmsService smsService;

	@GetMapping("/process")
	public String processSMS() {
		return "SMS sent";
	}

	@PostMapping("/send-otp")
	public OtpResponseDto sendOtp(@RequestBody OtpRequest otpRequest) {


		log.info("inside sendOtp :: " + otpRequest.getUsername());

		return smsService.sendSMS(otpRequest);
		
		
	}

	@PostMapping("/validate-otp")
	public String validateOtp(@RequestBody OtpValidationRequest otpValidationRequest) {
		log.info("inside validateOtp :: " + otpValidationRequest.getUsername() + " "
				+ otpValidationRequest.getOtpNumber());
		return smsService.validateOtp(otpValidationRequest);
	}

}
