package com.internaltools.service;

import javax.validation.Valid;

import com.internaltools.payload.request.ClientMasterRequest;
import com.internaltools.payload.response.ApiResponse;

/**
 * @author Pirai
 *
 */
public interface ClientMasterService {

	/**
	 * @param request
	 * @return
	 */
	ApiResponse createClientMaster(@Valid ClientMasterRequest request);
	
	

}
