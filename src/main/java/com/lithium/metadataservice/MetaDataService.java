package com.lithium.metadataservice;

import org.springframework.stereotype.Component;

import com.lithium.metadataservice.model.MetaData;
import com.lithium.metadataservice.repository.MetaDataRepository;

/**
 * @author Saiteja Tokala
 *
 */
@Component
public class MetaDataService {
	private final MetaDataRepository metaDataRepository;
	public MetaDataService(MetaDataRepository metaDataRepository) {
		this.metaDataRepository = metaDataRepository;
	}
	public MetaData writeNote(MetaData metaData){
		MetaData result = metaDataRepository.save(metaData);
		return result;
	}
}
