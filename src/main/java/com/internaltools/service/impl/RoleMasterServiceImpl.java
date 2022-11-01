package com.internaltools.service.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internaltools.payload.request.RoleMasterRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.persistence.entity.RoleMaster;
import com.internaltools.persistence.repository.RoleMasterRepository;
import com.internaltools.service.RoleMasterService;
import com.internaltools.util.ErrorConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RoleMasterServiceImpl implements RoleMasterService {

	@Autowired
	RoleMasterRepository roleMasterRepository;

	@Override
	public ApiResponse createRoleMaster(@Valid RoleMasterRequest roleMasterRequest) {

		ApiResponse response = new ApiResponse();
		try {
			RoleMaster roleMaster = new RoleMaster();

			roleMaster.setRoleName(roleMasterRequest.getRoleMasterModel().getRoleName());
			roleMaster.setDescription(roleMasterRequest.getRoleMasterModel().getDescription());
			//roleMaster.setIsActive(roleMasterRequest.getRoleMasterModel().getIsActive);
		
			roleMasterRepository.save(roleMaster);
		} catch (Exception e) {

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