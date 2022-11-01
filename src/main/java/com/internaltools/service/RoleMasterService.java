package com.internaltools.service;

import javax.validation.Valid;

import com.internaltools.payload.request.RoleMasterRequest;
import com.internaltools.payload.response.ApiResponse;

public interface RoleMasterService {

	ApiResponse createRoleMaster(@Valid RoleMasterRequest roleMasterRequest);

}
