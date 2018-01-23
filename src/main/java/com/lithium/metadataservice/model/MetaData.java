package com.lithium.metadataservice.model;

/**
 * @author Saiteja Tokala
 */

import org.hibernate.validator.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@javax.persistence.Entity
@Table(name = "metadata")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
		allowGetters = true)

@Getter @Setter
public class MetaData implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int nodeId;

	@NonNull @NotEmpty
	private String nodeName;

	@NonNull
	private boolean isSystemGenerated;

	private int authorOfMetadata;

	@NonNull
	private String metadataType;

	private int nodeAuthor;

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