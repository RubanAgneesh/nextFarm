package com.internaltools.service.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.internaltools.service.AmazonClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class InternalToolsImageScheduler {
	
	@Autowired
	AmazonClient amazonClient;
	
	
	
}
