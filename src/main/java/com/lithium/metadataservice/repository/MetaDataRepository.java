package com.lithium.metadataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lithium.metadataservice.model.MetaData;

/**
 * @author Saiteja Tokala
 */
@Repository
public interface MetaDataRepository extends JpaRepository<MetaData,Long> {
}
