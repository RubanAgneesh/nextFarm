package com.internaltools.event;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.internaltools.config.email.EmailObject;

import lombok.Data;

@Data
public class OnEmailSignUpEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1L;

	private Locale locale;

	private EmailObject emailObject;

	public OnEmailSignUpEvent(EmailObject emailObject, Locale locale) {
		super(emailObject);
		this.emailObject = emailObject;
		this.locale = locale;
	}
}
