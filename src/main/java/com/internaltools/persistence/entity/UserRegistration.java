package com.internaltools.persistence.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.envers.Audited;

import com.internaltools.persistence.model.audit.DateAudit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_registration")
@Builder
@Audited
public class UserRegistration extends DateAudit  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long registrationId;

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "USER_ID", referencedColumnName = "id")
	private User user;

	@Column
	private boolean otpValid;

	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp otpCreationTimestamp;

	private int otp;
	
	private boolean registered;
	
	private String createdBy;
	
	private String modifiedBy;

}
