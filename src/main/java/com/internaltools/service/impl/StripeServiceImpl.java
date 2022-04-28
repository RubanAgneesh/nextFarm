package com.internaltools.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.internaltools.persistence.repository.ConfigPropertiesRepository;
import com.internaltools.service.StripeService;
import com.stripe.model.Customer;
import com.stripe.model.Subscription;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StripeServiceImpl implements StripeService {

	@Value("${stripe.keys.secret}")
	private String API_SECRET_KEY;
	
	@Value("${stripe.refreshurl}")
	private String stripeRefreshUrl;
	
	@Value("${stripe.returnUrl}")
	private String stripeReturnUrl;
	
	@Value("${stripe.country}")
	private String stripeCountry;	

	@Autowired
	ConfigPropertiesRepository configPropertiesRepository;
	
	@Override
	public String createCustomer(String email, String token) {
        String id = null;
        try {
            Map<String, Object> customerParams = new HashMap<>();
            customerParams.put("description", "Customer for " + email);
            customerParams.put("email", email);
            customerParams.put("source", token);
            Customer customer = Customer.create(customerParams);
            id = customer.getId();
        } catch (Exception ex) {
        	log.error("Exception StripeServiceImpl :: createCustomer :: " + ex.getMessage());
            ex.printStackTrace();
        }
        return id;
    }
	
	@Override
	public String createSubscription(String customerId, String plan, String coupon) {
        
		String id = null;
        try {
            Map<String, Object> item = new HashMap<>();
            item.put("PAID PLAN", plan);
            Map<String, Object> items = new HashMap<>();
            items.put("0", item);
            Map<String, Object> params = new HashMap<>();
            params.put("customer", customerId);
            params.put("items", items);
            Subscription sub = Subscription.create(params);
            id = sub.getId();
        } catch (Exception ex) {
        	log.error("Exception StripeServiceImpl :: createSubscription :: " + ex.getMessage());
            ex.printStackTrace();
        }
        return id;
    }

	@Override
    public boolean cancelSubscription(String subscriptionId) {
        
    	boolean status;
        try {
            Subscription sub = Subscription.retrieve(subscriptionId);
            sub.cancel();
            status = true;
        } catch (Exception ex) {
        	log.error("Exception StripeServiceImpl :: createSubscription :: " + ex.getMessage());
            ex.printStackTrace();
            status = false;
        }
        return status;
    }

}
