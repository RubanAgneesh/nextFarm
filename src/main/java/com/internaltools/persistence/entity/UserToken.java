package com.internaltools.persistence.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;

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
public class UserToken implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private Long userid;
	
	@NotBlank
	private String token;
	
	private String userName;
	
	private String isActive;
	
	private String createdBy;
	
	private String modifiedBy;
}