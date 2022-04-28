package com.internaltools.payload.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request implements Serializable{

	private static final long serialVersionUID = 1L;

	private String userId;
	private float latitude;
	private float longitude;
	private String tokenId;
	private boolean isGuestUser;
	private String region;
	private String timeZone;

}
