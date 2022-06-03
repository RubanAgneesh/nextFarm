package com.internaltools.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")//, uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }) })
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
public class User { //extends DateAudit {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String email;
	
	@Size(max = 50)
	private String password;
	
	
	@NotNull
	private int roleId;
	
	@NotNull
	private String companyCode;
	
	//private String empId;
	
	private String token;
	
	private Boolean active;
	

}