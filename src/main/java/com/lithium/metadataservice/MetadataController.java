package com.lithium.metadataservice;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lithium.metadataservice.model.MetaData;
import com.lithium.metadataservice.repository.MetaDataRepository;

/**
 * @author Saiteja Tokala
 */
@RestController
public class MetadataController {

	private final MetaDataService metaDataService;

	private final MetaDataRepository metaDataRepository;
	public MetadataController(MetaDataService metaDataService, MetaDataRepository metaDataRepository){

		this.metaDataService = metaDataService;
		this.metaDataRepository = metaDataRepository;
	}

	// Create a new MetaData
	@PostMapping("/metadata")
	public MetaData createNote(@Valid @RequestBody MetaData metaData) {

		return metaDataRepository.save(metaData);
	}

	// Get All Notes
	@PostMapping("/metadataBatch")
	public List<MetaData> getMetadataBatch(@RequestBody MetaDataPojo metaDataPojo) {
		final Integer nodeId = metaDataPojo.getNodeId();
		final String nodeName = metaDataPojo.getNodeName();
		final Integer authorOfMetadata = metaDataPojo.getAuthorOfMetadata();

		final String tenantId = metaDataPojo.getTenantId();
		final String metadataType = metaDataPojo.getMetadataType();
		if(nodeId !=null && nodeName !=null && authorOfMetadata !=null && tenantId !=null && metadataType !=null){
			return metaDataRepository.findByNodeIdAndNodeNameAndAuthorOfMetadataAndTenantIdAndMetadataType(nodeId, nodeName, authorOfMetadata, tenantId, metadataType);
		}
		if(nodeId !=null && nodeName !=null && authorOfMetadata !=null && tenantId !=null){
			return metaDataRepository.findByNodeIdAndNodeNameAndAuthorOfMetadataAndTenantId(nodeId, nodeName, authorOfMetadata, tenantId);
		}
		if(nodeId !=null && nodeName !=null && authorOfMetadata !=null){
			return metaDataRepository.findByNodeIdAndNodeNameAndAuthorOfMetadata(nodeId, nodeName, authorOfMetadata);
		}
		if(nodeId !=null && nodeName !=null){
			return metaDataRepository.findByNodeIdAndNodeName(nodeId, nodeName);
		}
		if(nodeId !=null){
			return metaDataRepository.findByNodeId(nodeId);
		}

//		if(metaDataPojo.getNodeId()!=null){
//			return metaDataRepository.findByNodeId(metaDataPojo.getNodeId());
//		}


		//return metaDataRepository.findByNodeIdAndNodeName(metaDataPojo.getNodeId(),metaDataPojo.getNodeName());
		return metaDataRepository.findByNodeIdAndNodeNameAndAuthorOfMetadataAndTenantIdAndMetadataType(metaDataPojo.getNodeId(),metaDataPojo.getNodeName(),metaDataPojo.getAuthorOfMetadata(),metaDataPojo.getTenantId(),metaDataPojo.getTenantId());
	}

//	@RequestMapping(method = RequestMethod.GET, value = "/metadata")
//	@ResponseBody
//	public List<User> search(@RequestParam(value = "search") String search) {
//		MetaDataSpecificationsBuilder builder = new MetaDataSpecificationsBuilder();
//		Pattern pattern = Pattern.compile("(\w+?)(:|<|>)(\w+?),");
//		Matcher matcher = pattern.matcher(search + ",");
//		while (matcher.find()) {
//			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
//		}
//
//		Specification<User> spec = builder.build();
//		return repo.findAll(spec);
//	}

	// Get All Notes
	@GetMapping("/metadata")
	public List<MetaData> getAllNotes() {
		return metaDataRepository.findAll();
	}

	// Get a Single MetaData
	@GetMapping("/metadata/{id}")
	public ResponseEntity<MetaData> getNoteById(@PathVariable(value = "id") Long metadataId) {
		MetaData metaData = metaDataRepository.findOne(metadataId);
		if(metaData == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(metaData);
	}



	// Delete a MetaData
	@DeleteMapping("/metadata/{id}")
	public ResponseEntity<MetaData> deleteNote(@PathVariable(value = "id") Long metadataId) {
		MetaData metaData = metaDataRepository.findOne(metadataId);
		if(metaData == null) {
			return ResponseEntity.notFound().build();
		}

		metaDataRepository.delete(metaData);
		return ResponseEntity.ok().build();
	}
}

