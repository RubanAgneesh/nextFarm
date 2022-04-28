package com.internaltools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.internaltools.payload.response.ApiResponse;
import com.internaltools.service.StripeService;
import com.internaltools.service.UserService;
import com.internaltools.util.ErrorConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import lombok.extern.slf4j.Slf4j;

@Api(tags = { "Stripe Controller" })
@SwaggerDefinition(tags = { @Tag(name = "Menu details", description = "search Menu for Restaurant") })
@RestController
@RequestMapping("/api/payment")
@Slf4j
public class StripeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private StripeService stripeService;
	
	@PostMapping("/createSubscription")
    public @ResponseBody
    ApiResponse createSubscription(String email, String token, String plan, String coupon) {
       
		if (token == null || plan.isEmpty()) {
            return new ApiResponse(false, "Stripe payment token is missing. Please, try again later.", ErrorConstants.ERROR_CODE_401);
        }
        String customerId = stripeService.createCustomer(email, token);

        if (customerId == null) {
            return new ApiResponse(false, "An error occurred while trying to create a customer.", ErrorConstants.ERROR_CODE_401);
        }

        String subscriptionId = stripeService.createSubscription(customerId, plan, coupon);
        if (subscriptionId == null) {
            return new ApiResponse(false, "An error occurred while trying to create a subscription.", ErrorConstants.ERROR_CODE_401);
        }
        return new ApiResponse(true, "Success! Your subscription id is " + subscriptionId, ErrorConstants.ERROR_CODE_200);
    }
}
