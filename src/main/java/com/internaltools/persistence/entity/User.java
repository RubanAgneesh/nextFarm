package com.internaltools.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;

import com.internaltools.persistence.model.audit.DateAudit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }) })
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
public class User extends DateAudit {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 5)
	private String title;
	
	@Size(max = 50)
	private String firstName;
	
	@Size(max = 50)
	private String lastName;
	
	private String username;
	
	private String email;
	
	@Size(max = 100)
	private String password;
	
	private String countryCode;
	
	private String mobileNumber;
	
	private Date dateOfBirth;
	
	@Column(columnDefinition = "boolean default false")
	private boolean isDeleted;
	
	@Column(columnDefinition = "boolean default false")
	private boolean isActive;
	
	@Column(columnDefinition = "boolean default false")
	private boolean isRegistered;

	private String deviceToken;
	
	private String imageUrl;
	
	private String imageKey;
	
	private String providerType;
	
	private String firebaseNotificationToken;
	
	private int otpCount;
	
	@Column(columnDefinition = "boolean default true")
	private boolean isNotificationToken;

	@Transient
	private int otp;
	
	@Transient
	private String activationToken;
	
	@Transient
	private String changePasswordToken;
	
	private String timeZone;
	
	private String country;
	
	private Long referredBy;
	
}