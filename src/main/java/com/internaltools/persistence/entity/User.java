package com.internaltools.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;

import com.internaltools.persistence.model.audit.DateAudit;

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
public class User extends DateAudit implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size (max=30)
	private String firstName;
	
	@Size(max=30)
	private String lastName;

	private String userEmailId;

	private String password;

	private String imageUrl;
	
	private String imageKey;

	private String imagePath;

	@Column(columnDefinition = "boolean default false")
	private boolean isActive;
	
	@Column(columnDefinition = "boolean default false")
	private boolean isRegistered;

	private String firebaseNotificationToken;
	
	@Transient
	private String changePasswordToken;

	private int otp;
	
	private int otpCount;

	private String voterId;

	private String aadharNumber;

	private String aadharName;

	private String mobileNumber;

	private String gender;

	private String fatherName;

	private String country;

	private String state;

	private String district;

	private String village;

	private String pinCode;

	private String assemblyConstituency;


}
