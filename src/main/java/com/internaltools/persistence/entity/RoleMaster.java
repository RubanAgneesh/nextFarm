package com.internaltools.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "role_master")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
public class RoleMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String roleName;

	private String description;
	
	private boolean active;
	
	private boolean hidden;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "USER_ID", referencedColumnName = "id")
	private User user;
	
}
