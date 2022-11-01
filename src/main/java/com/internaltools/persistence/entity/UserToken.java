package com.internaltools.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.envers.Audited;

import com.internaltools.persistence.model.audit.DateAudit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(indexes = { @Index(name = "idx_token_code", columnList = "token") })
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class UserToken extends DateAudit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "USER_ID", referencedColumnName = "id")
	private User user;
	
	@NotBlank
	private String token;
	
	private String isActive;
	
	private String createdBy;
	
	private String modifiedBy;

	private String userName; 
}