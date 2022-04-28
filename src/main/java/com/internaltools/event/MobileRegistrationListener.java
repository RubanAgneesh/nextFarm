package com.internaltools.event;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.internaltools.config.sms.SmsObject;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MobileRegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {

	@Value("${documends.aws.api.access.key}")
	private String apiKey;

	@Value("${documends.aws.api.secret.key}")
	private String apiSecret;

	@Override
	public void onApplicationEvent(OnRegistrationCompleteEvent event) {
		this.confirmRegistration(event);
	}

	private void confirmRegistration(OnRegistrationCompleteEvent event) {

		SmsObject object = event.getSmsObject();

		BasicAWSCredentials awsCredentials = new BasicAWSCredentials(apiKey, apiSecret);

		AmazonSNSClient snsClient = (AmazonSNSClient) AmazonSNSClient.builder()
				.withRegion(Regions.US_WEST_2)
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
				.build();
		
		String message = object.getSmsText() + object.getOtp();
		String phoneNumber = object.getMobileNumber();
		
		Map<String, MessageAttributeValue> smsAttributes = new HashMap<String, MessageAttributeValue>();
		smsAttributes.put("AWS.SNS.SMS.SenderID",
				new MessageAttributeValue().withStringValue("documends").withDataType("String"));
		smsAttributes.put("AWS.SNS.SMS.MaxPrice",
				new MessageAttributeValue().withStringValue("0.50").withDataType("Number"));
		smsAttributes.put("AWS.SNS.SMS.SMSType",
				new MessageAttributeValue().withStringValue("Transactional").withDataType("String"));
		
		sendSMSMessage(snsClient, message, phoneNumber, smsAttributes);
	}

	private void sendSMSMessage(AmazonSNSClient snsClient, String message, String phoneNumber,
			Map<String, MessageAttributeValue> smsAttributes) {
		
		PublishResult result = snsClient.publish(new PublishRequest()
				.withMessage(message)
				.withPhoneNumber(phoneNumber)
				.withMessageAttributes(smsAttributes));
		
		log.debug(result.toString());
	}

}
