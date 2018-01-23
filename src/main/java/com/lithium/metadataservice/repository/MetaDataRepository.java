package com.lithium.metadataservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lithium.metadataservice.model.MetaData;

/**
 * @author Saiteja Tokala
 */
@Repository
public interface MetaDataRepository extends JpaRepository<MetaData,Long> {
//
//	private Integer nodeId;
//	private String nodeName;
//	private Integer authorOfMetadata;
//	private String tenantId;
//	private String metadataType;

	List<MetaData> findByNodeIdAndNodeNameAndAuthorOfMetadataAndTenantIdAndMetadataType(int nodeId,String nodeName,int authorOfMetadata,String tenantId,String metadataType);
	List<MetaData> findByNodeIdAndNodeNameAndAuthorOfMetadata(int nodeId,String nodeName,int authorOfMetadata);
	List<MetaData> findByNodeIdAndNodeNameAndAuthorOfMetadataAndTenantId(int nodeId,String nodeName,int authorOfMetadata,String tenantId);
	List<MetaData> findByNodeIdAndNodeName(int nodeId,String nodeName);
	List<MetaData> findByNodeId(int nodeId);

}
