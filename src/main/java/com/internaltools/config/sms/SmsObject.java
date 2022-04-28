package com.internaltools.config.sms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SmsObject {
	private int otp;
	private String mobileNumber;
	private String smsText;
	private String region;
}
