package com.internaltools.payload.response;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import lombok.Data;

@Data
public class ExceptionResponse implements Serializable{
	private Date timestamp;
	private String message;
	private String details;
	private Map<String, String> errorDetails;
	private boolean status;

	public ExceptionResponse(Date timestamp, String message, String details,boolean status) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.status = status;
	}

	public ExceptionResponse(Date timestamp, String message, String details, Map<String, String> errorDetails,boolean status) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.errorDetails = errorDetails;
		this.status = status;
	}
}