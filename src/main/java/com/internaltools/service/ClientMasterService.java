package com.internaltools.service;

import java.util.List;

import javax.validation.Valid;

import com.internaltools.payload.request.ClientMasterRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.service.model.ClientMasterModel;

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
	List<ClientMasterModel> getClientList();
	
	

}
