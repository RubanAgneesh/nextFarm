package com.internaltools.event;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.internaltools.config.sms.SmsObject;

import lombok.Data;

@Data
public class OnRegistrationCompleteEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	private Locale locale;

	private SmsObject smsObject;

	public OnRegistrationCompleteEvent(SmsObject smsObject, Locale locale) {
		super(smsObject);
		this.smsObject = smsObject;
		this.locale = locale;
	}
}
