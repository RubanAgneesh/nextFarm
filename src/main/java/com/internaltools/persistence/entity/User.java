package com.internaltools.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@NotNull
	@Size(max = 50)
	private String password;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "ROLE_ID", referencedColumnName = "roleId")
	private RoleMaster roleMaster;

	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "COMPANY_ID", referencedColumnName = "companyId")
	private Company company;
	
	@NotNull
	private String userName;
	
	private String token;
	
	private Boolean active;
	

}