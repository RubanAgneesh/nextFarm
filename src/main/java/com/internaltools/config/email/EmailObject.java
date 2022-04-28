package com.internaltools.config.email;

import javax.mail.Multipart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class EmailObject {
	
	private String senderemailId;
	
	private String reciveremailId;
	
	private String ccemailId;
	
	private String bccemailId;
	
	private String subject;
	
	private Multipart multipart;
}
