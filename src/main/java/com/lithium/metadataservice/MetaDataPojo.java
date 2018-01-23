package com.lithium.metadataservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Saiteja Tokala
 */
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class MetaDataPojo {

	private Integer nodeId;
	private String nodeName;
	private Integer authorOfMetadata;
	private String tenantId;
	private String metadataType;

	private boolean isCount;
	private int limit;
	private int oofSet;
}
