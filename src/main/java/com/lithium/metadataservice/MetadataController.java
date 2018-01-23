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

	// Update a MetaData
	@PutMapping("/metadata/{id}")
	public ResponseEntity<MetaData> updateNote(@PathVariable(value = "id") Long metadataId,
			@Valid @RequestBody MetaData metaDataDetails) {
		MetaData metaData = metaDataRepository.findOne(metadataId);
		if(metaData == null) {
			return ResponseEntity.notFound().build();
		}
		metaData.setNodeId(metaDataDetails.getNodeId());
		metaData.setAuthorOfMetadata(metaDataDetails.getAuthorOfMetadata());
		metaData.setMetadataType(metaDataDetails.getMetadataType());
		metaData.setNodeAuthor(metaDataDetails.getNodeAuthor());
		metaData.setNodeName(metaDataDetails.getNodeName());
		metaData.setTenantId(metaDataDetails.getTenantId());
		metaData.setSystemGenerated(metaDataDetails.isSystemGenerated());

		MetaData updatedMetaData = metaDataRepository.save(metaData);
		return ResponseEntity.ok(updatedMetaData);
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

