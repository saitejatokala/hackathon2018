package com.lithium.metadataservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Saiteja Tokala
 */
@javax.persistence.Entity
@Table(name = "hypermetadata")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
		allowGetters = true)


@Getter @Setter
public class HyperMetaData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NonNull
	private String metadataType;


	@NonNull @NotEmpty
	private String nodeName;

	@NonNull
	private String tenantId;


	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
}
