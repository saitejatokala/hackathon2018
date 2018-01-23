package com.lithium.metadataservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Saiteja Tokala
 */
@Getter @Setter @AllArgsConstructor
public class SearchCriteria {
	private String key;
	private String operation;
	private Object value;
}