package com.internaltools.config.pushnotification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationObject {
	
	private String restaurantNotificationToken;
	
	private String customerNotificationToken;
	
	private String orderStatus;
	
	private String customerName;
	
	private String orderRejectionReason;
}
