package com.vinaykumar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class OtpValidationRequest {
	private String username;
	private String otpNumber;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOtpNumber() {
		return otpNumber;
	}
	public void setOtpNumber(String otpNumber) {
		this.otpNumber = otpNumber;
	}
	public OtpValidationRequest(String username, String otpNumber) {
		super();
		this.username = username;
		this.otpNumber = otpNumber;
	}
	
	
}
