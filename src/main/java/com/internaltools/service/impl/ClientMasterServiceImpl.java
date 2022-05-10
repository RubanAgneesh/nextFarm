package com.internaltools.service.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internaltools.util.ErrorConstants;
import com.internaltools.payload.request.ClientMasterRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.persistence.repository.ClientMasterRepository;
import com.internaltools.persistence.repository.UserRepository;
import com.internaltools.service.ClientMasterService;
import com.internaltools.persistence.entity.ClientMaster;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClientMasterServiceImpl  implements ClientMasterService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ClientMasterRepository clientMasterRepository;
	
	
	
	@Override
	public ApiResponse createClientMaster(@Valid ClientMasterRequest request) {
		ApiResponse response = new ApiResponse();
		
		
		try
		{
			if (null == request.getClientMasterModel().getClientName()) {
				response.setMessage("Client Name is mandatory");
				response.setStatus(Boolean.FALSE);
				response.setStatusCode(ErrorConstants.ERROR_CODE_401);
				return response;
			}
		ClientMaster clientMaster = new ClientMaster();
		clientMaster.setClientName(request.getClientMasterModel().getClientName());
		
		clientMasterRepository.save(clientMaster);
		}
		catch(Exception e) {
			log.error("Exception in transferFromManualTransaction :: " + e.getMessage());
			response.setStatus(false);
			response.setMessage("Failure");
			response.setStatusCode(ErrorConstants.ERROR_CODE_401);
			return response;
			
		}
	
		response.setStatus(true);
		response.setMessage("Success");
		response.setStatusCode(ErrorConstants.ERROR_CODE_200);
		return response;
		
	}

}
