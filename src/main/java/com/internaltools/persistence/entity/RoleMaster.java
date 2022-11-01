package com.internaltools.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.internaltools.persistence.model.audit.DateAudit;
import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "role_master")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
public class RoleMaster extends DateAudit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String roleName;

	private String description;

	private String createdBy;

	private String modifiedBy;

	private boolean active;

}
