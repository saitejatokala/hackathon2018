package com.lithium.metadataservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import com.lithium.metadataservice.model.MetaData;

/**
 * @author Saiteja Tokala
 */
public class MetaDataSpecificationsBuilder {
	private final List<SearchCriteria> params;

	public MetaDataSpecificationsBuilder() {
		params = new ArrayList<SearchCriteria>();
	}

	public MetaDataSpecificationsBuilder with(String key, String operation, Object value) {
		params.add(new SearchCriteria(key, operation, value));
		return this;
	}

	public Specification<MetaData> build() {
		if (params.size() == 0) {
			return null;
		}

		List<Specification<MetaData>> specs = new ArrayList<Specification<MetaData>>();
//		for (SearchCriteria param : params) {
//			specs.add(new MetaDataSpecification(param));
//		}

		Specification<MetaData> result = specs.get(0);
		for (int i = 1; i < specs.size(); i++) {
			result = Specifications.where(result).and(specs.get(i));
		}
		return result;
	}
}
