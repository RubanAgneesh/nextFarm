package com.internaltools.persistence.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table
public class ConfigProperties {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long configPropertyId;

	private String configName;
	
	private String configDescription;
	
	private String configValue;
	
	private boolean isActive;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	private String createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedOn;
	
	private String modifiedBy;

}
