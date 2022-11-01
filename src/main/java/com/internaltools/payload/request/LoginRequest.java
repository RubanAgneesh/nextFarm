package com.internaltools.payload.request;

import com.internaltools.service.model.UserCreateModel;
import lombok.Data;

@Data
public class LoginRequest {
	private UserCreateModel userCreateModel;
}
