package com.internaltools.event;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.internaltools.config.email.EmailObject;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EmailRegistrationListener implements ApplicationListener<OnEmailSignUpEvent> {
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void onApplicationEvent(OnEmailSignUpEvent event) {
		this.confirmRegistration(event);
	}

	private void confirmRegistration(OnEmailSignUpEvent event) {
		try {
			EmailObject emailObject = event.getEmailObject();

			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(new InternetAddress(emailObject.getSenderemailId()));
			helper.setTo(new InternetAddress(emailObject.getReciveremailId()));

			helper.setSubject(emailObject.getSubject());

			message.setContent(emailObject.getMultipart());
			mailSender.send(message);
			log.debug("Email sent to {} ", emailObject.getReciveremailId());
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
