package com.lithium.metadataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lithium.metadataservice.model.HyperMetaData;

/**
 * @author Saiteja Tokala
 */
@Repository
public interface HyperMetaDataRepository extends JpaRepository<HyperMetaData,Long> {
}
