package com.internaltools.service;

public interface StripeService {

	/**
	 * @param email
	 * @param token
	 * @return String
	 */
	String createCustomer(String email, String token);

	/**
	 * @param customerId
	 * @param plan
	 * @param coupon
	 * @return String
	 */
	String createSubscription(String customerId, String plan, String coupon);

	/**
	 * @param subscriptionId
	 * @return boolean
	 */
	boolean cancelSubscription(String subscriptionId);
	
}
